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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mentoapp.dotorit.presentation.ui.theme.DotoritTheme
import com.mentoapp.dotorit.presentation.ui.theme.Neutral400
import com.mentoapp.dotorit.presentation.ui.theme.Orange900
import com.mentoapp.dotorit.presentation.ui.theme.White
import com.mentoapp.dotorit.presentation.ui.theme.dotoritTypography

@Composable
fun DefaultButton(
    text: String,
    enabled: Boolean = true,
    onClick: (Boolean) -> Unit = {}
) {
    Button(
        onClick = { onClick(enabled) },
        enabled = enabled,
        colors = ButtonDefaults.buttonColors(
            containerColor = Orange900,
            contentColor = Orange900,
            disabledContainerColor = Neutral400,
            disabledContentColor = Neutral400
        ),
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .fillMaxWidth(),
        contentPadding = PaddingValues(0.dp)
    ) {
        Text(
            text = text,
            modifier = Modifier.padding(vertical = 15.dp),
            color = White,
            style = dotoritTypography().bodyMedium1.copy(fontWeight = FontWeight.Bold)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun LoginButtonPreview() {
    DotoritTheme {
        Column {
            DefaultButton(text = "다음", enabled = false)
            DefaultButton("다음")
        }
    }
}