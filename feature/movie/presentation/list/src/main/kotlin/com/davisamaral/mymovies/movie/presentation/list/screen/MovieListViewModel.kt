package com.davisamaral.mymovies.movie.presentation.list.screen

import androidx.lifecycle.ViewModel
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.davisamaral.mymovies.movie.domain.model.Movie
import kotlinx.coroutines.flow.Flow

class MovieListViewModel(
    private val source: PopularMoviesPagingSource
) : ViewModel() {

    fun getMovies(): Flow<PagingData<Movie>> {
        return Pager(PagingConfig(20)) { source }.flow
    }
}