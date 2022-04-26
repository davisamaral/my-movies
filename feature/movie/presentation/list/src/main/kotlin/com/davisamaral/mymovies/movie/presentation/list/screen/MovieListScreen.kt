package com.davisamaral.mymovies.movie.presentation.list.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.itemsIndexed
import com.davisamaral.mymovies.designsystem.view.TMDBImage
import com.davisamaral.mymovies.designsystem.view.TMDBImageSize
import com.davisamaral.mymovies.movie.domain.model.Movie
import com.davisamaral.mymovies.movie.navigation.MovieNavigator
import com.davisamaral.mymovies.utility.navigation.TopBarManager

@Composable
fun MovieListScreen(
    listState: LazyListState,
    movieNavigator: MovieNavigator,
    topBarManager: TopBarManager,
    source: PopularMoviesPagingSource,
    movieListViewModel: MovieListViewModel = viewModel(
        factory = MovieListViewModelFactory(source)
    )
) {
    val lazyMovies: LazyPagingItems<Movie> =
        movieListViewModel.getMovies().collectAsLazyPagingItems()

    //val result = handlePagingResult(movies = lazyMovies)

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        state = listState,
        verticalArrangement = Arrangement.Center,
    ) {
        topBarManager.setPageTitle("Popular Movies")
        itemsIndexed(lazyMovies) { index, movie ->
            val isLastRow = lazyMovies.itemCount - 1 == index
            movie?.let {
                MovieRow(
                    movieId = movie.id,
                    movieTitle = movie.title,
                    movieDescription = movie.overview,
                    movieImageUrl = movie.backdropPath,
                    isLastRow = isLastRow
                ) { movieId ->
                    movieNavigator.navigateToMovieDetailScreen(movieId = movieId)
                }
            }
        }
    }
}

@Composable
fun handlePagingResult(
    movies: LazyPagingItems<Movie>
): Boolean {
    movies.apply {
        val error = when {
            loadState.refresh is LoadState.Error -> loadState.refresh as LoadState.Error
            loadState.prepend is LoadState.Error -> loadState.prepend as LoadState.Error
            loadState.append is LoadState.Error -> loadState.append as LoadState.Error
            else -> null
        }

        return when {
            loadState.refresh is LoadState.Loading -> {
                LoadingIndeterminate()
                false
            }
            error != null -> {
                EmptyScreen(error = error)
                false
            }
            else -> true
        }
    }
}

@Composable
fun LoadingIndeterminate() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        CircularProgressIndicator()
    }
}

@Composable
fun MovieRow(
    movieId: Long,
    movieTitle: String,
    movieDescription: String,
    movieImageUrl: String?,
    isLastRow: Boolean,
    onClick: (Long) -> Unit = {}
) {

    Divider(
        modifier = Modifier.fillMaxWidth(),
        color = MaterialTheme.colors.surface,
        thickness = 8.dp,
    )

    Row(
        modifier = Modifier
            .clickable { onClick(movieId) }
            .background(MaterialTheme.colors.background)
            .padding(horizontal = 10.dp, vertical = 10.dp)
            .fillMaxWidth()
            .wrapContentHeight(),
    ) {
        TMDBImage(
            modifier = Modifier.fillMaxWidth(0.4F),
            contentScale = ContentScale.FillWidth,
            imagePath = movieImageUrl,
            imageSize = TMDBImageSize.MEDIUM,
            contentDescription = movieTitle
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(start = 10.dp)
        ) {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = movieTitle,
                style = MaterialTheme.typography.subtitle1,
                color = MaterialTheme.colors.onBackground
            )
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 4.dp),
                text = movieDescription,
                maxLines = 3,
                style = MaterialTheme.typography.caption,
                color = MaterialTheme.colors.onBackground,
                overflow = TextOverflow.Ellipsis
            )
        }
    }

    if (isLastRow) {
        Divider(
            modifier = Modifier.fillMaxWidth(),
            color = MaterialTheme.colors.surface,
            thickness = 8.dp,
        )
    }
}

@Preview
@Composable
fun MovieRowPreview() {
    MovieRow(
        movieId = 0L,
        movieTitle = "A volta dos q não foram",
        movieDescription = "Lorem ipsim dolor sit amet",
        movieImageUrl = null,
        isLastRow = true
    )
}