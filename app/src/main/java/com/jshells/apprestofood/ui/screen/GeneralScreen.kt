package com.jshells.apprestofood.ui.screen

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.jshells.apprestofood.ui.paddings.paddingEnd
import com.jshells.apprestofood.ui.paddings.paddingStart
import com.jshells.apprestofood.ui.paddings.paddingTop

class GeneralScreen {

    @Composable
    fun Main() {
        LazyColumn(
            Modifier.fillMaxWidth()
                .padding(
                    top = paddingTop,
                    start = paddingStart,
                    end = paddingEnd
                )
        ) { }
    }

}