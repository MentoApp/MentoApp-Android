package com.mentoapp.dotorit.presentation.join.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mentoapp.dotorit.R
import com.mentoapp.dotorit.domain.usecase.ValidateNicknameUseCase
import com.mentoapp.dotorit.presentation.join.component.DefaultButton
import com.mentoapp.dotorit.presentation.join.component.NicknameInputField
import com.mentoapp.dotorit.presentation.ui.theme.DotoritTheme
import com.mentoapp.dotorit.presentation.ui.theme.Neutral400
import com.mentoapp.dotorit.presentation.ui.theme.White
import com.mentoapp.dotorit.presentation.ui.theme.dotoritTypography

@Composable
fun JoinProfileScreen(
    viewModel: JoinProfileViewModel,
    onBackClick: () -> Unit = {},
    onButtonClick: () -> Unit = {},
) {
    val nickname by viewModel.nickname.collectAsState()
    val errorMessage by viewModel.errorMessage.collectAsState()
    val buttonEnabled by viewModel.buttonEnabled.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(White)
    ) {
        TopAppBar()

        Column(
            modifier = Modifier
                .weight(1f)
                .background(White)
                .padding(horizontal = 16.dp)
        ) {
            Spacer(
                modifier = Modifier
                    .padding(top = 32.dp)
            )

            Box(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(
                    text = stringResource(R.string.join_profile_title),
                    style = dotoritTypography().headlineBold2.copy(
                        lineHeight = 28.sp
                    )
                )

                Row(
                    modifier = Modifier.align(Alignment.BottomEnd)
                ) {
                    Text(
                        text = "1",
                        style = dotoritTypography().headlineBold4
                    )

                    Text(
                        text = "/3",
                        style = dotoritTypography().bodyMedium1.copy(
                            color = Neutral400
                        )
                    )
                }
            }

            Image(
                painter = painterResource(R.drawable.img_profile_default),
                contentDescription = "profile",
                modifier = Modifier
                    .padding(top = 32.dp, bottom = 40.dp)
                    .align(Alignment.CenterHorizontally)
            )

            NicknameInputField(
                label = stringResource(R.string.join_profile_nickname),
                placeholder = stringResource(R.string.join_profile_nickname_placeholder),
                value = nickname,
                onValueChange = {
                    viewModel.updateNickname(it)
                    viewModel.validateNickname(it)
                },
                isError = errorMessage != null,
                errorMessage = errorMessage
            )

            Spacer(
                modifier = Modifier
                    .weight(1f)
            )

            DefaultButton(
                text = stringResource(R.string.join_profile_next),
                enabled = buttonEnabled,
                onClick = { },
            )

            Spacer(
                modifier = Modifier
                    .padding(top = 16.dp)
            )
        }
    }
}

@Composable
private fun TopAppBar(
    onBackClick: () -> Unit = {}
) {
    IconButton(
        onClick = { onBackClick() },
        modifier = Modifier
    ) {
        Icon(
            painter = painterResource(R.drawable.ic_arrow_left),
            contentDescription = "back"
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun JoinProfileScreenPreview() {
    val viewModel = JoinProfileViewModel(ValidateNicknameUseCase())

    DotoritTheme {
        JoinProfileScreen(viewModel)
    }
}