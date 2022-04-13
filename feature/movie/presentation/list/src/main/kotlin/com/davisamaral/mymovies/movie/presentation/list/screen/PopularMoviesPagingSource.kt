package com.davisamaral.mymovies.movie.presentation.list.screen

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.davisamaral.mymovies.movie.domain.model.Movie
import com.davisamaral.mymovies.movie.domain.usecase.GetPopularMoviesUseCase

class PopularMoviesPagingSource(
    private val getPopularMovies: GetPopularMoviesUseCase
) : PagingSource<Int, Movie>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Movie> {

        val nextPage = params.key ?: 1
        val gamesResponse = getPopularMovies(nextPage)

        return if (gamesResponse.isEmpty()) {
            LoadResult.Error(Exception("No more results"))
        } else {
            LoadResult.Page(
                data = gamesResponse,
                prevKey =
                if (nextPage == 1) null
                else nextPage - 1,
                nextKey = nextPage.plus(1)
            )
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Movie>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }
}