package com.jshells.apprestofood

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.jshells.apprestofood.presentation.screen.MainScreen
import com.jshells.apprestofood.presentation.theme.AppRestoFoodTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppRestoFoodTheme() {
                MainScreen()
            }
        }
    }
}
