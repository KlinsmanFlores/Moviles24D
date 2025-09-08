package com.example.businesscard.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

// Colores personalizados para la Business Card
private val LightColorScheme = lightColorScheme(
    primary = Color(0xFF006D3B),         // Verde Android oscuro
    onPrimary = Color.White,
    primaryContainer = Color(0xFF3DDC84), // Verde Android claro
    onPrimaryContainer = Color(0xFF073042),
    secondary = Color(0xFF073042),        // Azul oscuro
    onSecondary = Color.White,
    background = Color(0xFFD2E8D4),      // Verde menta claro
    onBackground = Color(0xFF2B2B2B),
    surface = Color.White,
    onSurface = Color(0xFF2B2B2B)
)

private val DarkColorScheme = darkColorScheme(
    primary = Color(0xFF3DDC84),         // Verde Android claro
    onPrimary = Color(0xFF073042),
    primaryContainer = Color(0xFF006D3B), // Verde Android oscuro
    onPrimaryContainer = Color.White,
    secondary = Color(0xFF073042),        // Azul oscuro
    onSecondary = Color.White,
    background = Color(0xFF1B1B1B),      // Fondo oscuro
    onBackground = Color.White,
    surface = Color(0xFF2B2B2B),
    onSurface = Color.White
)

@Composable
fun BusinessCardTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) {
        DarkColorScheme
    } else {
        LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography(),
        content = content
    )
}