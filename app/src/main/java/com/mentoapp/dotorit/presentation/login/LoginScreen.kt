package com.mentoapp.dotorit.presentation.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mentoapp.dotorit.R
import com.mentoapp.dotorit.domain.entity.LoginType
import com.mentoapp.dotorit.presentation.login.component.LoginButton
import com.mentoapp.dotorit.presentation.ui.theme.DotoritTheme
import com.mentoapp.dotorit.presentation.ui.theme.Neutral500
import com.mentoapp.dotorit.presentation.ui.theme.Neutral600
import com.mentoapp.dotorit.presentation.ui.theme.Neutral800
import com.mentoapp.dotorit.presentation.ui.theme.Orange60
import com.mentoapp.dotorit.presentation.ui.theme.dotoritTypography

@Composable
fun LoginScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Orange60)
            .padding(horizontal = 24.dp),
        verticalArrangement = Arrangement.SpaceAround
    ) {
        LoginScreenTitle(
            modifier = Modifier
                .weight(1f)
        )
        Spacer(
            modifier = Modifier
                .weight(1f)
        )
        LoginButtons()
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 34.dp),
            text = stringResource(R.string.login_service_info),
            style = dotoritTypography().bodyMedium1,
            color = Neutral500,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun LoginScreenTitle(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Bottom
    ) {
        Image(
            modifier = Modifier
                .padding(bottom = 24.dp),
            painter = painterResource(R.drawable.img_logo),
            contentDescription = "logo"
        )
        Text(
            modifier = Modifier
                .padding(bottom = 12.dp),
            text = stringResource(R.string.login_title),
            style = dotoritTypography().headlineBold1,
            color = Neutral800
        )
        Text(
            text = stringResource(R.string.login_subtitle),
            style = dotoritTypography().bodyMedium1,
            color = Neutral600
        )
    }
}

@Composable
fun LoginButtons() {
    Column(
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        LoginButton(LoginType.NAVER)
        LoginButton(LoginType.KAKAO)
    }
}

@Preview(
    showBackground = true
)
@Composable
private fun LoginScreenPreview() {
    DotoritTheme {
        LoginScreen()
    }
}