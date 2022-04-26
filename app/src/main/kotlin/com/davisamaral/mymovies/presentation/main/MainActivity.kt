package com.davisamaral.mymovies.presentation.main

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.collectAsState
import androidx.navigation.NavHostController
import com.davisamaral.mymovies.designsystem.theme.MyMoviesTheme
import com.davisamaral.mymovies.presentation.navigation.AppMainScreen
import com.davisamaral.mymovies.utility.kotlin.extensions.injectMultibinding
import com.davisamaral.mymovies.utility.navigation.BottomBarItem
import com.davisamaral.mymovies.utility.navigation.NavigationDefinition
import com.davisamaral.mymovies.utility.navigation.NavigationManager
import com.davisamaral.mymovies.utility.navigation.TopBarManager
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import org.koin.android.ext.android.getKoin
import org.koin.android.ext.android.inject
import org.koin.androidx.fragment.android.setupKoinFragmentFactory

@ExperimentalAnimationApi
@ExperimentalMaterialApi
class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavHostController
    private val bottomBarItems by getKoin().injectMultibinding<BottomBarItem>()
    private val navigationDefinitions by getKoin().injectMultibinding<NavigationDefinition>()
    private val topBarManager by inject<TopBarManager>()
    private val navigationManager by inject<NavigationManager>()

    override fun onCreate(savedInstanceState: Bundle?) {
        setupKoinFragmentFactory()
        super.onCreate(savedInstanceState)
        setComposeContent()

    }

    private fun setComposeContent() {
        setContent {
            MyMoviesTheme {
                navController = rememberAnimatedNavController()
                navigationManager.navigationCommands.collectAsState().value.also { command ->
                    if (!command?.destination.isNullOrBlank()) {
                        navController.navigate(command?.destination.orEmpty()) {
                            command?.popUpTo?.let {
                                popUpTo(it) {
                                    inclusive = command.popUpInclusive
                                }
                            }
                        }
                    }
                }
                AppMainScreen(
                    navController = navController,
                    navigationDefinitions = navigationDefinitions,
                    bottomBarItems = bottomBarItems,
                    topBarManager = topBarManager,
                )
            }
        }
    }
}
