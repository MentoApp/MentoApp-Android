package com.mentoapp.dotorit.presentation.login

import androidx.compose.ui.graphics.Color
import com.mentoapp.dotorit.domain.entity.LoginType

data class LoginTypeUiModel(
    val type: LoginType,
    val displayName: String,
    val buttonColor: Color
)

fun LoginType.toUiModel(): LoginTypeUiModel = when (this) {
    LoginType.NAVER -> LoginTypeUiModel(
        type = LoginType.NAVER,
        displayName = "네이버",
        buttonColor = Color(0xFF34C947)
    )

    LoginType.KAKAO -> LoginTypeUiModel(
        type = LoginType.KAKAO,
        displayName = "카카오",
        buttonColor = Color(0xFFFFCC49)
    )
}