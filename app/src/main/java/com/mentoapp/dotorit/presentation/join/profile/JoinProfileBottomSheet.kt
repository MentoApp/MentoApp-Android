package com.mentoapp.dotorit.presentation.join.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mentoapp.dotorit.R
import com.mentoapp.dotorit.presentation.join.component.DefaultButton
import com.mentoapp.dotorit.presentation.ui.theme.DotoritTheme
import com.mentoapp.dotorit.presentation.ui.theme.Neutral600
import com.mentoapp.dotorit.presentation.ui.theme.Neutral800
import com.mentoapp.dotorit.presentation.ui.theme.Orange900
import com.mentoapp.dotorit.presentation.ui.theme.ProfileBackground1
import com.mentoapp.dotorit.presentation.ui.theme.ProfileBackground2
import com.mentoapp.dotorit.presentation.ui.theme.ProfileBackground3
import com.mentoapp.dotorit.presentation.ui.theme.ProfileBackground4
import com.mentoapp.dotorit.presentation.ui.theme.ProfileBackground5
import com.mentoapp.dotorit.presentation.ui.theme.ProfileBackground6
import com.mentoapp.dotorit.presentation.ui.theme.dotoritTypography

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun JoinProfileBottomSheet(
    onDoneClick: (selectedImageRes: Int, selectedBgColor: Color) -> Unit,
    onDismissRequest: () -> Unit
) {
    val hamsterImages = listOf(
        R.drawable.img_profile_1,
        R.drawable.img_profile_2,
        R.drawable.img_profile_3,
        R.drawable.img_profile_4
    )
    val bgColors = listOf(
        ProfileBackground1,
        ProfileBackground2,
        ProfileBackground3,
        ProfileBackground4,
        ProfileBackground5,
        ProfileBackground6
    )

    var selectedTabIndex by remember { mutableIntStateOf(0) }
    var selectedHamsterIndex by remember { mutableIntStateOf(0) }
    var selectedBgColorIndex by remember { mutableIntStateOf(0) }

    val sheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = true
    )

    ModalBottomSheet(
        onDismissRequest = onDismissRequest,
        sheetState = sheetState
    ) {
        Column(
            modifier = Modifier.padding(20.dp)
        ) {
            Text(
                text = stringResource(id = R.string.join_profile_bottom_sheet_title),
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(vertical = 8.dp),
                textAlign = TextAlign.Center
            )

            TabRow(
                selectedTabIndex = selectedTabIndex,
                modifier = Modifier.fillMaxWidth()
            ) {
                Tab(
                    selected = selectedTabIndex == 0,
                    onClick = { selectedTabIndex = 0 },
                    text = {
                        Text(
                            text = stringResource(id = R.string.join_profile_bottom_sheet_character)
                        )
                    }
                )
                Tab(
                    selected = selectedTabIndex == 1,
                    onClick = { selectedTabIndex = 1 },
                    text = {
                        Text(
                            text = stringResource(id = R.string.join_profile_bottom_sheet_photo)
                        )
                    }
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            Box(
                modifier = Modifier.align(Alignment.CenterHorizontally)
            ) {
                Box(
                    modifier = Modifier
                        .size(100.dp)
                        .clip(CircleShape)
                        .background(bgColors[selectedBgColorIndex])
                        .padding(16.dp)
                ) {
                    Image(
                        painter = painterResource(id = hamsterImages[selectedHamsterIndex]),
                        contentDescription = null,
                        modifier = Modifier.fillMaxSize()
                    )
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Box(
                    modifier = Modifier
                        .size(20.dp)
                        .background(Neutral600, CircleShape)
                        .align(Alignment.CenterVertically)
                ) {
                    Text(
                        text = "1",
                        color = Color.White,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.align(Alignment.Center),
                        style = dotoritTypography().headlineBold1.copy(fontSize = 10.sp)
                    )
                }
                Text(
                    text = stringResource(id = R.string.join_profile_bottom_sheet_character_1),
                    modifier = Modifier.padding(start = 4.dp),
                    style = dotoritTypography().bodyMedium1,
                    color = Neutral800
                )
            }

            Spacer(modifier = Modifier.height(12.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                hamsterImages.forEachIndexed { index, image ->
                    Box(
                        modifier = Modifier
                            .size(60.dp)
                            .clip(CircleShape)
                            .background(bgColors[selectedBgColorIndex])
                            .then(
                                if (selectedHamsterIndex == index)
                                    Modifier.border(2.dp, Color(0xFFFF8A3D), CircleShape)
                                else
                                    Modifier
                            )
                            .clickable { selectedHamsterIndex = index }
                    ) {
                        Image(
                            painter = painterResource(id = image),
                            contentDescription = null,
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(8.dp)
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Box(
                    modifier = Modifier
                        .size(20.dp)
                        .background(Neutral600, CircleShape)
                        .align(Alignment.CenterVertically)
                ) {
                    Text(
                        text = "2",
                        color = Color.White,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.align(Alignment.Center),
                        style = dotoritTypography().headlineBold1.copy(fontSize = 10.sp)
                    )
                }
                Text(
                    text = stringResource(id = R.string.join_profile_bottom_sheet_character_2),
                    modifier = Modifier.padding(start = 4.dp),
                    style = dotoritTypography().bodyMedium1,
                    color = Neutral800
                )
            }

            Spacer(modifier = Modifier.height(12.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                bgColors.forEachIndexed { index, color ->
                    Box(
                        modifier = Modifier
                            .size(40.dp)
                            .clip(CircleShape)
                            .background(color)
                            .then(
                                if (selectedBgColorIndex == index)
                                    Modifier.border(2.dp, Orange900, CircleShape)
                                else
                                    Modifier
                            )
                            .clickable { selectedBgColorIndex = index }
                    )
                }
            }

            Spacer(modifier = Modifier.height(32.dp))

            DefaultButton(
                text = stringResource(R.string.join_profile_bottom_sheet_submit),
            ) {
                onDoneClick(hamsterImages[selectedHamsterIndex], bgColors[selectedBgColorIndex])
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun JoinProfileScreenPreview() {
    DotoritTheme {
        JoinProfileBottomSheet(
            onDoneClick = { imageRes, color -> /* 미리보기에서는 아무 동작도 하지 않습니다 */ },
            onDismissRequest = {}
        )
    }
}