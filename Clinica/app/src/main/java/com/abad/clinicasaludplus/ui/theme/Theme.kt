package com.abad.clinicasaludplus.ui.theme

import android.app.Activity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val LightColorScheme = lightColorScheme(
    primary = TealPrimary,
    onPrimary = SurfaceWhite,
    primaryContainer = TealContainer,
    onPrimaryContainer = TealDark,
    secondary = TealAccent,
    onSecondary = SurfaceWhite,
    secondaryContainer = TealContainer,
    onSecondaryContainer = TealDark,
    background = BackgroundLight,
    onBackground = TextPrimary,
    surface = SurfaceWhite,
    onSurface = TextPrimary,
    surfaceVariant = TealSurface,
    onSurfaceVariant = TextSecondary,
    outline = TealLight.copy(alpha = 0.3f)
)

private val DarkColorScheme = darkColorScheme(
    primary = TealLight,
    onPrimary = TextPrimary,
    primaryContainer = TealDark,
    onPrimaryContainer = TealContainer,
    secondary = TealAccent,
    onSecondary = TextPrimary,
    background = TextPrimary,
    onBackground = BackgroundLight,
    surface = TextPrimary,
    onSurface = BackgroundLight
)

@Composable
fun ClinicaSaludPlusTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color deshabilitado para mantener la identidad turquesa/verde azulado
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme

    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.primary.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = false
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
