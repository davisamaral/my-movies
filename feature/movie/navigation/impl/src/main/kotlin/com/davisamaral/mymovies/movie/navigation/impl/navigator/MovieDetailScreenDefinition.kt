package com.davisamaral.mymovies.movie.navigation.impl.navigator

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.davisamaral.mymovies.movie.domain.usecase.GetMovieDetailUseCase
import com.davisamaral.mymovies.movie.presentation.detail.screen.MovieDetailScreen
import com.davisamaral.mymovies.utility.navigation.NavigationCommand
import com.davisamaral.mymovies.utility.navigation.ScreenDefinition
import com.davisamaral.mymovies.utility.navigation.TopBarManager
import com.google.accompanist.navigation.animation.composable

class MovieDetailScreenDefinition(
    private val getMovieDetail: GetMovieDetailUseCase,
    private val topBarManager: TopBarManager,
) : ScreenDefinition {

    override val route: String = "$MOVIE_DETAIL_ROUTE/{$MOVIE_ID_KEY}"
    override val arguments: List<NamedNavArgument> = listOf(
        navArgument(MOVIE_ID_KEY) { type = NavType.LongType }
    )

    @Suppress("OPT_IN_IS_NOT_ENABLED")
    @OptIn(ExperimentalAnimationApi::class)
    override fun configureNavigation(navGraphBuilder: NavGraphBuilder) {
        navGraphBuilder.apply {
            composable(
                route = this@MovieDetailScreenDefinition.route,
                arguments = arguments,
                content = { backStackEntry ->
                    val movieId = backStackEntry.arguments?.getLong(MOVIE_ID_KEY) ?: 0
                    MovieDetailScreen(
                        movieId = movieId,
                        getMovieDetail = getMovieDetail,
                        topBarManager = topBarManager,
                    )
                }
            )
        }
    }

    class MovieDetailNavigationCommand(movieId: Long) : NavigationCommand {
        override val popUpInclusive: Boolean = false
        override val popUpTo: String? = null
        override val destination: String = "$MOVIE_DETAIL_ROUTE/$movieId"
    }

    companion object {
        private const val MOVIE_DETAIL_ROUTE = "movieDetailScreen"
        private const val MOVIE_ID_KEY = "movieId"
    }
}