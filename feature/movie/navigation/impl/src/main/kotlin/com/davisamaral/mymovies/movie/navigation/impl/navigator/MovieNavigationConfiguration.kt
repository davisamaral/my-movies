package com.davisamaral.mymovies.movie.navigation.impl.navigator

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.davisamaral.mymovies.movie.domain.usecase.GetMovieDetailUseCase
import com.davisamaral.mymovies.movie.navigation.MovieNavigator
import com.davisamaral.mymovies.movie.presentation.detail.screen.MovieDetailScreen
import com.davisamaral.mymovies.movie.presentation.list.screen.MovieListScreen
import com.davisamaral.mymovies.movie.presentation.list.screen.PopularMoviesPagingSource
import com.davisamaral.mymovies.utility.navigation.NavigationConfiguration
import com.davisamaral.mymovies.utility.navigation.TopBarManager
import com.google.accompanist.navigation.animation.composable

@ExperimentalAnimationApi
internal class MovieNavigationConfiguration(
    private val source: PopularMoviesPagingSource,
    private val getMovieDetail: GetMovieDetailUseCase,
    private val movieNavigator: MovieNavigator,
    private val topBarManager: TopBarManager,
) : NavigationConfiguration {

    override val route: String = "movie"

    override fun configureNavigation(
        navGraphBuilder: NavGraphBuilder,
        navController: NavController
    ) {
        navGraphBuilder.navigation(startDestination = "movieList", route = route) {
            composable(
                route = "movieList",
                arguments = listOf(navArgument("title") { defaultValue = "Movies" })
            ) {
                val listState = rememberLazyListState()
                MovieListScreen(
                    movieNavigator = movieNavigator,
                    navController = navController,
                    topBarManager = topBarManager,
                    source = source,
                    listState = listState,
                )
            }
            composable(
                route = "movieDetail/{movieId}",
                arguments = listOf(navArgument("title") { defaultValue = "Movie" })
            ) { backStackEntry ->
                val movieId = backStackEntry.arguments?.getString("movieId")?.toLong() ?: 0L
                MovieDetailScreen(
                    getMovieDetail = getMovieDetail,
                    movieId = movieId,
                    topBarManager = topBarManager,
                )
            }
        }
    }
}

