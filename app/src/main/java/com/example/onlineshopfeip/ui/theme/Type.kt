package com.example.onlineshopfeip.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.onlineshopfeip.R

private val montserratFontFamily = FontFamily(
    Font(
        resId = R.font.montserrat_regular,
        weight = FontWeight(400)
    ),
    Font(
        resId = R.font.montserrat_medium,
        weight = FontWeight(500)
    ),
    Font(
        resId = R.font.montserrat_semibold,
        weight = FontWeight(600)
    )
)

private val cormorantGaramondFontFamily = FontFamily(
    Font(
        resId = R.font.cormorant_garamond_regular,
        weight = FontWeight(400)
    ),
    Font(
        resId = R.font.cormorant_garamond_semibold,
        weight = FontWeight(600)
    )
)

// Set of Material typography styles to start with
val Typography = Typography(
    labelSmall = TextStyle(
        fontSize = 12.sp,
        fontWeight = FontWeight(500),
        fontFamily = montserratFontFamily
    ),
    labelMedium = TextStyle(
        fontFamily = montserratFontFamily,
        fontWeight = FontWeight(400),
        fontSize = 14.sp
    ),
    labelLarge = TextStyle(
        fontFamily = montserratFontFamily,
        fontWeight = FontWeight(400),
        fontSize = 18.sp
    ),
    bodyMedium = TextStyle(
        fontFamily = montserratFontFamily,
        fontSize = 14.sp,
        fontWeight = FontWeight(400)
    ),
    bodyLarge = TextStyle(
        fontFamily = montserratFontFamily,
        fontSize = 16.sp,
        fontWeight = FontWeight(400)
    ),
    titleMedium = TextStyle(
        fontFamily = cormorantGaramondFontFamily,
        fontWeight = FontWeight(600),
        fontSize = 22.sp
    ),
    titleLarge = TextStyle(
        fontFamily = cormorantGaramondFontFamily,
        fontWeight = FontWeight(400),
        fontSize = 24.sp
    )
)

