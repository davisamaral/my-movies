package com.davisamaral.mymovies.movie.presentation.detail.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun MovieDetailScreen(movieTitle: String) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.surface),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            modifier = Modifier.wrapContentSize(),
            style = MaterialTheme.typography.h2,
            text = movieTitle,
            textAlign = TextAlign.Center,
            color = MaterialTheme.colors.onSurface
        )
    }
}

@Preview
@Composable
fun MovieDetailScreenPreview() {
    MovieDetailScreen("A volta dos que não foram")
}