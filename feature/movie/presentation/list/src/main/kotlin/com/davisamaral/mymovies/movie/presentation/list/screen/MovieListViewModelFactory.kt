package com.davisamaral.mymovies.movie.presentation.list.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MovieListViewModelFactory(
    private val source: PopularMoviesPagingSource
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(PopularMoviesPagingSource::class.java).newInstance(source)
    }
}