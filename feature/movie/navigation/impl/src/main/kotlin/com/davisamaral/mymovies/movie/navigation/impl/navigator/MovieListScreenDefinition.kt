package com.davisamaral.mymovies.movie.navigation.impl.navigator

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavGraphBuilder
import com.davisamaral.mymovies.movie.navigation.MovieNavigator
import com.davisamaral.mymovies.movie.presentation.list.screen.MovieListScreen
import com.davisamaral.mymovies.movie.presentation.list.screen.PopularMoviesPagingSource
import com.davisamaral.mymovies.utility.navigation.NavigationCommand
import com.davisamaral.mymovies.utility.navigation.ScreenDefinition
import com.davisamaral.mymovies.utility.navigation.TopBarManager
import com.google.accompanist.navigation.animation.composable

class MovieListScreenDefinition(
    private val movieNavigator: MovieNavigator,
    private val topBarManager: TopBarManager,
    private val source: PopularMoviesPagingSource,
) : ScreenDefinition {

    override val route: String = MOVIE_LIST_ROUTE
    override val arguments: List<NamedNavArgument> = emptyList()

    @Suppress("OPT_IN_IS_NOT_ENABLED")
    @OptIn(ExperimentalAnimationApi::class)
    override fun configureNavigation(navGraphBuilder: NavGraphBuilder) {
        navGraphBuilder.apply {
            composable(
                route = this@MovieListScreenDefinition.route,
                arguments = arguments,
                content = {
                    val listState = rememberLazyListState()
                    MovieListScreen(
                        listState = listState,
                        movieNavigator = movieNavigator,
                        topBarManager = topBarManager,
                        source = source,
                    )
                }
            )
        }
    }

    class MovieListNavigationCommand : NavigationCommand {
        override val popUpInclusive: Boolean = false
        override val popUpTo: String? = null
        override val destination: String = MOVIE_LIST_ROUTE
    }

    companion object {
        private const val MOVIE_LIST_ROUTE = "movieListScreen"
    }
}