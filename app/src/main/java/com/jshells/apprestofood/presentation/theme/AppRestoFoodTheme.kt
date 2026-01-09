package com.jshells.apprestofood.presentation.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import com.jshells.apprestofood.presentation.theme.colorscheme.DarkColorScheme
import com.jshells.apprestofood.presentation.theme.colorscheme.LightColorScheme
import com.jshells.apprestofood.presentation.theme.typography.AppTypography

@Composable
fun AppRestoFoodTheme(
    dartTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (dartTheme) DarkColorScheme else LightColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        typography = AppTypography,
    ) {
        Surface(content = content)
    }
}