package com.davisamaral.mymovies.movie.presentation.detail.screen

import androidx.compose.runtime.Stable
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.davisamaral.mymovies.movie.domain.model.MovieDetail
import com.davisamaral.mymovies.movie.domain.usecase.GetMovieDetailUseCase
import kotlinx.coroutines.launch

class MovieDetailViewModel(
    private val getMovieDetail: GetMovieDetailUseCase,
) : ViewModel() {

    val movieState = MovieState()

    @Stable
    class MovieState {
        val movie = mutableStateOf<MovieDetail?>(null)
    }

    fun loadMovie(movieId: Long) = viewModelScope.launch {
        getMovieDetail(movieId).let { movie ->
            movieState.movie.value = movie
        }
    }
}