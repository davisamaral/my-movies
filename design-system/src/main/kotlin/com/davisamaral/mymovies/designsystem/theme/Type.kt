package com.davisamaral.mymovies.designsystem.theme

import androidx.compose.material.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp


val RobotoMonoTypography = Typography(
    h1 = TextStyle(
        fontWeight = FontWeight.Medium,
        fontSize = 32.sp,
    ),
    h2 = TextStyle(
        fontWeight = FontWeight.Medium,
        fontSize = 26.sp,
    ),
    h3 = TextStyle(
        fontWeight = FontWeight.Medium,
        fontSize = 22.sp,
    ),
    h4 = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 20.sp,
    ),
    h5 = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 18.sp,
    ),
    h6 = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
    ),
    subtitle1 = TextStyle(
        fontWeight = FontWeight.Medium,
        fontSize = 15.sp,
    ),
    subtitle2 = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
    ),
    body1 = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
    body2 = TextStyle(
        fontSize = 14.sp
    ),
    button = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        color = Color.White
    ),
    caption = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 13.sp
    ),
    overline = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 13.sp
    )
)