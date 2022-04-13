package com.davisamaral.mymovies.designsystem.view

import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.DefaultAlpha
import androidx.compose.ui.graphics.FilterQuality
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.compose.AsyncImagePainter
import coil.request.ImageRequest
import coil.transform.RoundedCornersTransformation
import com.davisamaral.mymovies.designsystem.R

enum class TMDBImageSize(val id: String) {
    SMALL("w200"), MEDIUM("w300"), LARGE("w400"), MAXIMUM("original")
}

@Composable
fun TMDBImage(
    imagePath: String?,
    contentDescription: String?,
    modifier: Modifier = Modifier,
    imageSize: TMDBImageSize = TMDBImageSize.MAXIMUM,
    transform: (AsyncImagePainter.State) -> AsyncImagePainter.State = AsyncImagePainter.DefaultTransform,
    onState: ((AsyncImagePainter.State) -> Unit)? = null,
    alignment: Alignment = Alignment.Center,
    contentScale: ContentScale = ContentScale.Fit,
    alpha: Float = DefaultAlpha,
    colorFilter: ColorFilter? = null,
    filterQuality: FilterQuality = DrawScope.DefaultFilterQuality,
) {
    AsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .data("https://image.tmdb.org/t/p/${imageSize.id}/$imagePath")
            .crossfade(true)
            .crossfade(300)
//            .transformations(RoundedCornersTransformation(4.dp.value))
            .placeholder(R.drawable.movie_placeholder)
            .build(),
        contentDescription = contentDescription,
        modifier = modifier,
        transform = transform,
        onState = onState,
        alignment = alignment,
        contentScale = contentScale,
        alpha = alpha,
        colorFilter = colorFilter,
        filterQuality = filterQuality,
    )
}