package com.davisamaral.mymovies.presentation.main

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.davisamaral.mymovies.designsystem.theme.MyMoviesTheme
import com.davisamaral.mymovies.movie.navigation.MovieNavigator
import com.davisamaral.mymovies.presentation.navigation.SetupNavGraph
import org.koin.android.ext.android.inject
import org.koin.androidx.fragment.android.setupKoinFragmentFactory

@ExperimentalAnimationApi
@ExperimentalMaterialApi
class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavHostController
    private val movieNavigator by inject<MovieNavigator>()

    override fun onCreate(savedInstanceState: Bundle?) {
        setupKoinFragmentFactory()
        super.onCreate(savedInstanceState)
        setContent {
            MyMoviesTheme {
                navController = rememberNavController()
                SetupNavGraph(
                    navController = navController,
                    movieNavigator = movieNavigator,
                )
            }
        }
    }
}
