package com.example.woof.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat


private val LightColors = lightColorScheme(
    primary = com.example.woof.ui.theme.md_theme_light_primary,
    onPrimary = com.example.woof.ui.theme.md_theme_light_onPrimary,
    primaryContainer = com.example.woof.ui.theme.md_theme_light_primaryContainer,
    onPrimaryContainer = com.example.woof.ui.theme.md_theme_light_onPrimaryContainer,
    secondary = com.example.woof.ui.theme.md_theme_light_secondary,
    onSecondary = com.example.woof.ui.theme.md_theme_light_onSecondary,
    secondaryContainer = com.example.woof.ui.theme.md_theme_light_secondaryContainer,
    onSecondaryContainer = com.example.woof.ui.theme.md_theme_light_onSecondaryContainer,
    tertiary = com.example.woof.ui.theme.md_theme_light_tertiary,
    onTertiary = com.example.woof.ui.theme.md_theme_light_onTertiary,
    tertiaryContainer = com.example.woof.ui.theme.md_theme_light_tertiaryContainer,
    onTertiaryContainer = com.example.woof.ui.theme.md_theme_light_onTertiaryContainer,
    error = com.example.woof.ui.theme.md_theme_light_error,
    errorContainer = com.example.woof.ui.theme.md_theme_light_errorContainer,
    onError = com.example.woof.ui.theme.md_theme_light_onError,
    onErrorContainer = com.example.woof.ui.theme.md_theme_light_onErrorContainer,
    background = com.example.woof.ui.theme.md_theme_light_background,
    onBackground = com.example.woof.ui.theme.md_theme_light_onBackground,
    surface = com.example.woof.ui.theme.md_theme_light_surface,
    onSurface = com.example.woof.ui.theme.md_theme_light_onSurface,
    surfaceVariant = com.example.woof.ui.theme.md_theme_light_surfaceVariant,
    onSurfaceVariant = com.example.woof.ui.theme.md_theme_light_onSurfaceVariant,
    outline = com.example.woof.ui.theme.md_theme_light_outline,
    inverseOnSurface = com.example.woof.ui.theme.md_theme_light_inverseOnSurface,
    inverseSurface = com.example.woof.ui.theme.md_theme_light_inverseSurface,
    inversePrimary = com.example.woof.ui.theme.md_theme_light_inversePrimary,
    surfaceTint = com.example.woof.ui.theme.md_theme_light_surfaceTint,
    outlineVariant = com.example.woof.ui.theme.md_theme_light_outlineVariant,
    scrim = com.example.woof.ui.theme.md_theme_light_scrim,
)


private val DarkColors = darkColorScheme(
    primary = com.example.woof.ui.theme.md_theme_dark_primary,
    onPrimary = com.example.woof.ui.theme.md_theme_dark_onPrimary,
    primaryContainer = com.example.woof.ui.theme.md_theme_dark_primaryContainer,
    onPrimaryContainer = com.example.woof.ui.theme.md_theme_dark_onPrimaryContainer,
    secondary = com.example.woof.ui.theme.md_theme_dark_secondary,
    onSecondary = com.example.woof.ui.theme.md_theme_dark_onSecondary,
    secondaryContainer = com.example.woof.ui.theme.md_theme_dark_secondaryContainer,
    onSecondaryContainer = com.example.woof.ui.theme.md_theme_dark_onSecondaryContainer,
    tertiary = com.example.woof.ui.theme.md_theme_dark_tertiary,
    onTertiary = com.example.woof.ui.theme.md_theme_dark_onTertiary,
    tertiaryContainer = com.example.woof.ui.theme.md_theme_dark_tertiaryContainer,
    onTertiaryContainer = com.example.woof.ui.theme.md_theme_dark_onTertiaryContainer,
    error = com.example.woof.ui.theme.md_theme_dark_error,
    errorContainer = com.example.woof.ui.theme.md_theme_dark_errorContainer,
    onError = com.example.woof.ui.theme.md_theme_dark_onError,
    onErrorContainer = com.example.woof.ui.theme.md_theme_dark_onErrorContainer,
    background = com.example.woof.ui.theme.md_theme_dark_background,
    onBackground = com.example.woof.ui.theme.md_theme_dark_onBackground,
    surface = com.example.woof.ui.theme.md_theme_dark_surface,
    onSurface = com.example.woof.ui.theme.md_theme_dark_onSurface,
    surfaceVariant = com.example.woof.ui.theme.md_theme_dark_surfaceVariant,
    onSurfaceVariant = com.example.woof.ui.theme.md_theme_dark_onSurfaceVariant,
    outline = com.example.woof.ui.theme.md_theme_dark_outline,
    inverseOnSurface = com.example.woof.ui.theme.md_theme_dark_inverseOnSurface,
    inverseSurface = com.example.woof.ui.theme.md_theme_dark_inverseSurface,
    inversePrimary = com.example.woof.ui.theme.md_theme_dark_inversePrimary,
    surfaceTint = com.example.woof.ui.theme.md_theme_dark_surfaceTint,
    outlineVariant = com.example.woof.ui.theme.md_theme_dark_outlineVariant,
    scrim = com.example.woof.ui.theme.md_theme_dark_scrim,
)

/*private val DarkColorScheme = darkColorScheme(
    primary = Purple80,
    secondary = PurpleGrey80,
    tertiary = Pink80
)

private val LightColorScheme = lightColorScheme(
    primary = Purple40,
    secondary = PurpleGrey40,
    tertiary = Pink40
)*/
val Shapes = Shapes(
    small = RoundedCornerShape(50.dp),
    medium = RoundedCornerShape(bottomStart = 16.dp, topEnd = 16.dp)
)

@Composable
fun AffirmationsTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColors
        else -> LightColors
    }
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.primary.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}