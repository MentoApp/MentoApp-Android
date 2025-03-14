package com.mentoapp.dotorit.presentation.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mentoapp.dotorit.R
import com.mentoapp.dotorit.presentation.ui.theme.DotoritTheme
import com.mentoapp.dotorit.presentation.ui.theme.Orange900

@Composable
fun SplashScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Orange900)
    ) {
        Image(
            modifier = Modifier
                .align(Alignment.Center)
                .width(92.dp),
            painter = painterResource(R.drawable.img_logo_white),
            contentDescription = null
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun SplashScreenPreview() {
    DotoritTheme {
        SplashScreen()
    }
}