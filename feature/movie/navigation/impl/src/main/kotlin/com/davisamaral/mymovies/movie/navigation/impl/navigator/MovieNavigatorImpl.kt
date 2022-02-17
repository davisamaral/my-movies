package com.davisamaral.mymovies.movie.navigation.impl.navigator

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.davisamaral.mymovies.movie.domain.usecase.GetMoviesUseCase
import com.davisamaral.mymovies.movie.navigation.MovieNavigator
import com.davisamaral.mymovies.movie.presentation.detail.screen.MovieDetailScreen
import com.davisamaral.mymovies.movie.presentation.list.screen.MovieListScreen

internal class MovieNavigatorImpl(
    private val getMovies: GetMoviesUseCase,
) : MovieNavigator {

    override fun configureNavigation(
        navGraphBuilder: NavGraphBuilder,
        navController: NavController
    ) {
        navGraphBuilder.navigation(startDestination = "movieList", route = "movies") {
            composable("movieList") {
                MovieListScreen(
                    movieNavigator = this@MovieNavigatorImpl,
                    navController = navController,
                    getMovies = getMovies,
                )
            }
            composable("movieDetail/{movieTitle}") { backStackEntry ->
                val movieTitle = backStackEntry.arguments?.getString("movieTitle").orEmpty()
                MovieDetailScreen(movieTitle)
            }
        }
    }

    override fun navigateToMovieListScreen(navController: NavController) {
        navController.navigate("movieList")
    }

    override fun navigateToMovieDetailScreen(movieTitle: String, navController: NavController) {
        navController.navigate("movieDetail/$movieTitle")
    }
}

