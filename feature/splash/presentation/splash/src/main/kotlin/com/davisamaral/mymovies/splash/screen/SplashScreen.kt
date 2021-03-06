package com.davisamaral.mymovies.splash.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.davisamaral.mymovies.splash.navigation.SplashNavigator

@Composable
fun SplashScreen(
    splashNavigator: SplashNavigator,
    splashViewModel: SplashViewModel = viewModel(factory = SplashViewModelFactory(splashNavigator)),
) {
    SplashContent(counterText = splashViewModel.splashState.counter.value)
}

@Composable
fun SplashContent(counterText: String) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            modifier = Modifier
                .wrapContentSize()
                .padding(all = 16.dp),
            color = MaterialTheme.colors.onBackground,
            fontSize = 48.sp,
            text = "SPLASH SCREEN",
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
        Text(
            color = MaterialTheme.colors.primary,
            fontSize = 68.sp,
            text = counterText,
            fontWeight = FontWeight.Bold
        )
    }
}

@Preview
@Composable
fun SplashContentPreview() {
    SplashContent("3")
}


