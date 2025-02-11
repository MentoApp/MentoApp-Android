package com.mentoapp.dotorit.presentation.login.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mentoapp.dotorit.R
import com.mentoapp.dotorit.domain.entity.LoginType
import com.mentoapp.dotorit.presentation.login.toUiModel
import com.mentoapp.dotorit.presentation.ui.theme.DotoritTheme
import com.mentoapp.dotorit.presentation.ui.theme.dotoritTypography

@Composable
fun LoginButton(
    loginType: LoginType,
    onClick: (LoginType) -> Unit = {}
) {
    Button(
        onClick = { onClick(loginType) },
        colors = ButtonDefaults.buttonColors(
            containerColor = loginType.toUiModel().buttonColor,
        ),
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = loginType.toUiModel().buttonColor,
                shape = RoundedCornerShape(8.dp)
            ),
        contentPadding = PaddingValues(0.dp)
    ) {
        Icon(
            painter = if (loginType == LoginType.NAVER) painterResource(R.drawable.ic_naver) else painterResource(
                R.drawable.ic_kakao
            ),
            contentDescription = null,
            tint = if (loginType == LoginType.NAVER) Color.White else Color.Black
        )
        Text(
            modifier = Modifier
                .padding(horizontal = 10.dp, vertical = 15.dp),
            text = "${loginType.toUiModel().displayName}로 시작하기",
            color = if (loginType == LoginType.NAVER) Color.White else Color.Black,
            style = dotoritTypography().headlineBold4.copy(
                fontSize = 15.sp
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun LoginButtonPreview() {
    DotoritTheme {
        Column {
            LoginButton(LoginType.NAVER)
            LoginButton(LoginType.KAKAO)
        }
    }
}