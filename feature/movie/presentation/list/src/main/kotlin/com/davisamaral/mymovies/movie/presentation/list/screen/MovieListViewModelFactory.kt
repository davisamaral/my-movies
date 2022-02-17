package com.davisamaral.mymovies.movie.presentation.list.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.davisamaral.mymovies.movie.domain.usecase.GetMoviesUseCase

class MovieListViewModelFactory(
    private val getMoviesUseCase: GetMoviesUseCase
) : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MovieListViewModel(getMoviesUseCase) as T
    }
}