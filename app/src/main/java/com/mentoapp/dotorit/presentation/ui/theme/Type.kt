package com.mentoapp.dotorit.presentation.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.mentoapp.dotorit.R

val PretendardBold = FontFamily(Font(R.font.pretendard_bold, FontWeight.Bold))
val PretendardMedium = FontFamily(Font(R.font.pretendard_medium, FontWeight.Medium))
val PretendardRegular = FontFamily(Font(R.font.pretendard_regular, FontWeight.Normal))
val PretendardSemiBold = FontFamily(Font(R.font.pretendard_semibold, FontWeight.SemiBold))

@Stable
class DotoritTypography(
    headlineBold1: TextStyle,
    headlineBold2: TextStyle,
    headlineBold3: TextStyle,
    headlineBold4: TextStyle,
    bodyMedium1: TextStyle,
    bodyMedium2: TextStyle
) {
    var headlineBold1: TextStyle by mutableStateOf(headlineBold1)
        private set
    var headlineBold2: TextStyle by mutableStateOf(headlineBold2)
        private set
    var headlineBold3: TextStyle by mutableStateOf(headlineBold3)
        private set
    var headlineBold4: TextStyle by mutableStateOf(headlineBold4)
        private set
    var bodyMedium1: TextStyle by mutableStateOf(bodyMedium1)
        private set
    var bodyMedium2: TextStyle by mutableStateOf(bodyMedium2)
        private set

    fun update(other: DotoritTypography) {
        headlineBold1 = other.headlineBold1
        headlineBold2 = other.headlineBold2
        headlineBold3 = other.headlineBold3
        headlineBold4 = other.headlineBold4
        bodyMedium1 = other.bodyMedium1
        bodyMedium2 = other.bodyMedium2
    }

    fun copy(
        headlineBold1: TextStyle = this.headlineBold1,
        headlineBold2: TextStyle = this.headlineBold2,
        headlineBold3: TextStyle = this.headlineBold3,
        headlineBold4: TextStyle = this.headlineBold4,
        bodyMedium1: TextStyle = this.bodyMedium1,
        bodyMedium2: TextStyle = this.bodyMedium2
    ): DotoritTypography = DotoritTypography(
        headlineBold1,
        headlineBold2,
        headlineBold3,
        headlineBold4,
        bodyMedium1,
        bodyMedium2
    )
}

fun calculateLetterSpacing(fontSize: TextUnit, percentage: Float): TextUnit {
    return (fontSize.value * (percentage / 100)).sp
}

@Composable
fun dotoritTypography(): DotoritTypography {
    return DotoritTypography(
        headlineBold1 = TextStyle(
            fontFamily = PretendardBold,
            fontSize = 24.sp,
            lineHeight = 31.2.sp,
            letterSpacing = calculateLetterSpacing(24.sp, -2.5f)
        ),
        headlineBold2 = TextStyle(
            fontFamily = PretendardBold,
            fontSize = 20.sp,
            lineHeight = 31.2.sp,
            letterSpacing = calculateLetterSpacing(20.sp, -2.5f)
        ),
        headlineBold3 = TextStyle(
            fontFamily = PretendardBold,
            fontSize = 18.sp,
            lineHeight = 28.sp,
            letterSpacing = calculateLetterSpacing(18.sp, -2.5f)
        ),
        headlineBold4 = TextStyle(
            fontFamily = PretendardBold,
            fontSize = 14.sp,
            lineHeight = 23.4.sp,
            letterSpacing = calculateLetterSpacing(14.sp, -2.5f)
        ),
        bodyMedium1 = TextStyle(
            fontFamily = PretendardRegular,
            fontSize = 14.sp,
            lineHeight = 19.6.sp,
            letterSpacing = calculateLetterSpacing(14.sp, -2.5f)
        ),
        bodyMedium2 = TextStyle(
            fontFamily = PretendardRegular,
            fontSize = 12.sp,
            lineHeight = 16.8.sp,
            letterSpacing = calculateLetterSpacing(12.sp, -2.5f)
        )
    )
}