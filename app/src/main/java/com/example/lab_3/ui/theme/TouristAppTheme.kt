package com.example.lab_3.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

// Vibrant travel-inspired colors
private val TravelBlue = Color(0xFF2196F3)
private val SunsetOrange = Color(0xFFFF9800)
private val ForestGreen = Color(0xFF4CAF50)
private val SkyBlue = Color(0xFF03A9F4)
private val SandBeige = Color(0xFFFFF3E0)
private val NightBlue = Color(0xFF1A237E)
private val MoonGray = Color(0xFFBDBDBD)

private val DarkColorScheme = darkColorScheme(
    primary = TravelBlue,
    onPrimary = Color.White,
    secondary = SunsetOrange,
    onSecondary = Color.Black,
    tertiary = ForestGreen,
    background = NightBlue,
    surface = NightBlue.copy(alpha = 0.7f),
    onBackground = Color.White,
    onSurface = Color.White
)

private val LightColorScheme = lightColorScheme(
    primary = TravelBlue,
    onPrimary = Color.White,
    secondary = SunsetOrange,
    onSecondary = Color.Black,
    tertiary = ForestGreen,
    background = SandBeige,
    surface = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F)
)

@Composable
fun TouristAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
