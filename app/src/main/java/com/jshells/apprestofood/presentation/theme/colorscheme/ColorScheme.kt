package com.jshells.apprestofood.presentation.theme.colorscheme

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import com.jshells.apprestofood.presentation.theme.colors.Black
import com.jshells.apprestofood.presentation.theme.colors.Purple500
import com.jshells.apprestofood.presentation.theme.colors.Purple700
import com.jshells.apprestofood.presentation.theme.colors.Teal200
import com.jshells.apprestofood.presentation.theme.colors.White

val LightColorScheme = lightColorScheme(
    primary = Purple500,
    onPrimary = White,
    primaryContainer = Purple700,
    secondary = Teal200,
    background = White,
    surface = White,
    onSurface = Black,
)

val DarkColorScheme = darkColorScheme(
    primary = Purple700,
    onPrimary = White,
    primaryContainer = Purple500,
    secondary = Teal200,
    background = Black,
    onBackground = White,
    surface = Black,
    onSurface = White,
)