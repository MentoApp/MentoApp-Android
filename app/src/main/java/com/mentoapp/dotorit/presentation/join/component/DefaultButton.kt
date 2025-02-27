package com.mentoapp.dotorit.presentation.join.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mentoapp.dotorit.presentation.ui.theme.DotoritTheme
import com.mentoapp.dotorit.presentation.ui.theme.Neutral400
import com.mentoapp.dotorit.presentation.ui.theme.Neutral900
import com.mentoapp.dotorit.presentation.ui.theme.White
import com.mentoapp.dotorit.presentation.ui.theme.dotoritTypography

@Composable
fun DefaultButton(
    buttonText: String,
    enabled: Boolean = true,
    onClick: (Boolean) -> Unit = {},
    modifier: Modifier = Modifier
) {
    Button(
        onClick = { onClick(enabled) },
        enabled = enabled,
        colors = ButtonDefaults.buttonColors(
            containerColor = Neutral900,
            contentColor = Neutral900,
            disabledContainerColor = Neutral400,
            disabledContentColor = Neutral400
        ),
        shape = RoundedCornerShape(8.dp),
        modifier = modifier
            .fillMaxWidth(),
        contentPadding = PaddingValues(0.dp)
    ) {
        Text(
            modifier = modifier
                .padding(horizontal = 70.dp, vertical = 15.dp),
            text = buttonText,
            color = White,
            style = dotoritTypography().bodyMedium1
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun LoginButtonPreview() {
    DotoritTheme {
        Column {
            DefaultButton(buttonText = "다음", enabled = false)
            DefaultButton("다음")
        }
    }
}