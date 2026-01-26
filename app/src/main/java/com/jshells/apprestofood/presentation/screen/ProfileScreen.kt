package com.jshells.apprestofood.presentation.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import com.jshells.apprestofood.R
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jshells.apprestofood.utils.m

@Composable
fun ProfileScreen() {

}

@Composable
fun Profile() {
    Row(
        modifier = m
            .fillMaxWidth()
            .padding(top = 24.dp)
            .background(Color.Red),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        IconButton(
            onClick = { },
            modifier = m
                .padding(start = 5.dp)
        ) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                contentDescription = "arrowBack",
                tint = Color.White
            )
        }

        IconButton(
            onClick = {},
            modifier = m
                .padding(start = 5.dp, end = 5.dp)
        ) {
            Icon(
                imageVector = Icons.Default.Settings,
                contentDescription = "arrowBack",
                tint = Color.White
            )
        }
    }

    Box(
        modifier = m
            .fillMaxSize()
            .size(140.dp)
            .padding(top = 90.dp),
        contentAlignment = Alignment.TopCenter
    ) {
        Image(
            painter = painterResource(R.drawable.test_profile),
            contentDescription = "profileImage",
        )
    }
}

@Composable
fun PaymentDetails() {}

@Composable
fun OrderHistory() {}

@Composable
fun EditProfile() {}

@Preview(showSystemUi = true)
@Composable
fun PreviewProfileScreen() {
    Profile()
    PaymentDetails()
    OrderHistory()
    EditProfile()
    NavController()
}