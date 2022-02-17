package com.davisamaral.mymovies.movie.presentation.list.screen

import androidx.compose.runtime.Stable
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.davisamaral.mymovies.movie.domain.model.Movie
import com.davisamaral.mymovies.movie.domain.usecase.GetMoviesUseCase
import kotlinx.coroutines.launch

class MovieListViewModel(
    private val getMoviesUseCase: GetMoviesUseCase
) : ViewModel() {

    val movieState = MovieState()

    @Stable
    class MovieState {
        val movies = mutableStateOf(emptyList<Movie>())
    }

    fun loadMovies() = viewModelScope.launch {
        getMoviesUseCase().let {
            movieState.movies.value = it
        }
    }
}