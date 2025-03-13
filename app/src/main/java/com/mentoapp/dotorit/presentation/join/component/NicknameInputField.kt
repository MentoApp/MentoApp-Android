package com.mentoapp.dotorit.presentation.join.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mentoapp.dotorit.R
import com.mentoapp.dotorit.presentation.ui.theme.Neutral300
import com.mentoapp.dotorit.presentation.ui.theme.Neutral400
import com.mentoapp.dotorit.presentation.ui.theme.Neutral500
import com.mentoapp.dotorit.presentation.ui.theme.Neutral700
import com.mentoapp.dotorit.presentation.ui.theme.StatusError
import com.mentoapp.dotorit.presentation.ui.theme.dotoritTypography

@Composable
fun NicknameInputField(
    label: String,
    placeholder: String,
    value: String,
    onValueChange: (String) -> Unit,
    errorMessage: String? = null,
    isError: Boolean = false
) {
    Column {
        Text(
            text = label,
            style = dotoritTypography().bodyMedium2.copy(
                fontWeight = FontWeight.Medium
            ),
            color = if (isError) StatusError else Neutral500
        )

        Spacer(modifier = Modifier.height(6.dp))

        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            modifier = Modifier
                .fillMaxWidth(),
            placeholder = {
                Text(
                    text = placeholder,
                    color = Neutral400,
                    style = dotoritTypography().bodyMedium1
                )
            },
            singleLine = true,
            isError = isError,
            shape = RoundedCornerShape(8.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = if (isError) StatusError else Neutral700,
                unfocusedBorderColor = if (isError) StatusError else Neutral300,
                errorBorderColor = StatusError,
            ),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )

        if (isError && errorMessage != null) {
            Spacer(modifier = Modifier.height(6.dp))
            Text(
                text = errorMessage,
                style = dotoritTypography().bodyMedium2,
                color = StatusError
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NicknameInputPreview() {
    var normalNickname by remember { mutableStateOf("두부") }
    var errorNickname by remember { mutableStateOf("두") }

    Column(modifier = Modifier.padding(16.dp)) {
        Text(
            text = "👤닉네임 필드 상태값",
            style = MaterialTheme.typography.headlineSmall
        )

        Spacer(modifier = Modifier.height(16.dp))

        NicknameInputField(
            label = stringResource(R.string.join_profile_nickname),
            placeholder = stringResource(R.string.join_profile_nickname_placeholder),
            value = normalNickname,
            onValueChange = { normalNickname = it },
        )

        Spacer(modifier = Modifier.height(24.dp))

        NicknameInputField(
            label = stringResource(R.string.join_profile_nickname),
            placeholder = stringResource(R.string.join_profile_nickname_placeholder),
            value = errorNickname,
            onValueChange = { errorNickname = it },
            isError = true,
            errorMessage = "에러메시지 노출 영역"
        )

        Spacer(modifier = Modifier.height(24.dp))

        NicknameInputField(
            label = stringResource(R.string.join_profile_nickname),
            placeholder = stringResource(R.string.join_profile_nickname_placeholder),
            value = "",
            onValueChange = { },
        )
    }
}