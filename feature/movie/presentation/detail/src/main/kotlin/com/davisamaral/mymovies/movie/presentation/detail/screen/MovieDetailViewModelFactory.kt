package com.davisamaral.mymovies.movie.presentation.detail.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.davisamaral.mymovies.movie.domain.usecase.GetMovieDetailUseCase

class MovieDetailViewModelFactory(
    private val getMovieDetail: GetMovieDetailUseCase
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(GetMovieDetailUseCase::class.java)
            .newInstance(getMovieDetail)
    }
}