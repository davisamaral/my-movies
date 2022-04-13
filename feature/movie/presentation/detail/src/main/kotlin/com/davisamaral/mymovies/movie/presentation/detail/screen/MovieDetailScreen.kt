package com.davisamaral.mymovies.movie.presentation.detail.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.davisamaral.mymovies.designsystem.view.TMDBImage
import com.davisamaral.mymovies.movie.domain.usecase.GetMovieDetailUseCase
import com.davisamaral.mymovies.utility.navigation.TopBarManager

@Composable
fun MovieDetailScreen(
    movieId: Long,
    getMovieDetail: GetMovieDetailUseCase,
    topBarManager: TopBarManager,
    viewModel: MovieDetailViewModel = viewModel(
        factory = MovieDetailViewModelFactory(getMovieDetail)
    )
) {
    remember { viewModel.loadMovie(movieId) }
    topBarManager.setPageTitle(viewModel.movieState.movie.value?.title.orEmpty())
    MovieDetailContent(
        movieTitle = viewModel.movieState.movie.value?.title.orEmpty(),
        posterPath = viewModel.movieState.movie.value?.posterPath,
    )
}


@Composable
fun MovieDetailContent(
    movieTitle: String,
    posterPath: String?
) {

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.TopCenter,
    ) {

        TMDBImage(
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillWidth,
            imagePath = posterPath,
            contentDescription = movieTitle
        )
        Box(
            modifier = Modifier
                .padding(top = 16.dp)
                .background(MaterialTheme.colors.surface.copy(alpha = 0.7f))
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(horizontal = 16.dp, vertical = 8.dp)


        ) {
            Text(
                modifier = Modifier.fillMaxWidth(),
                style = MaterialTheme.typography.h2,
                text = movieTitle,
                textAlign = TextAlign.Center,
                color = MaterialTheme.colors.onSurface
            )
        }
    }
}

@Preview
@Composable
fun MovieDetailContentPreview() {
    MovieDetailContent(movieTitle = "A volta dos que não foram", posterPath = "")
}