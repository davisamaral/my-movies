package com.davisamaral.mymovies.movie.presentation.list.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.davisamaral.mymovies.movie.domain.usecase.GetMoviesUseCase
import com.davisamaral.mymovies.movie.navigation.MovieNavigator

@Composable
fun MovieListScreen(
    movieNavigator: MovieNavigator,
    navController: NavController,
    getMovies: GetMoviesUseCase,
    movieListViewModel: MovieListViewModel = viewModel(
        factory = MovieListViewModelFactory(getMovies)
    )
) {
    remember { movieListViewModel.loadMovies() }
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
    ) {
        itemsIndexed(movieListViewModel.movieState.movies.value) { index, movie ->
            Divider(
                modifier = Modifier.fillMaxWidth(),
                color = MaterialTheme.colors.primary,
                thickness = 1.dp,
            )
            MovieRow(movieTitle = "${index + 1} - ${movie.title}") { movieTitle ->
                movieNavigator.navigateToMovieDetailScreen(movieTitle, navController)
            }
            if (movieListViewModel.movieState.movies.value.size - 1 == index) {
                Divider(
                    modifier = Modifier.fillMaxWidth(),
                    color = MaterialTheme.colors.primary,
                    thickness = 1.dp,
                )
            }
        }
    }
}

@Composable
fun MovieRow(
    movieTitle: String,
    onClick: (String) -> Unit = {}
) {
    Text(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colors.surface)
            .padding(vertical = 8.dp, horizontal = 16.dp)
            .clickable { onClick(movieTitle) },
        text = movieTitle,
        style = MaterialTheme.typography.subtitle1,
        color = MaterialTheme.colors.onSurface
    )
}

@Preview
@Composable
fun MovieRowPreview() {
    MovieRow(movieTitle = "A volta dos q não foram")
}