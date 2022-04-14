package com.dehalex.giphy.ui.common.toolbars

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dehalex.giphy.R
import com.dehalex.giphy.values.colors.AppColors

@Composable
fun MainToolbar(
    modifier: Modifier = Modifier,
    title: String,
    onSearchClick: () -> Unit,
    onSettingClick: () -> Unit,
) {

    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(56.dp)
            .background(AppColors.Violet),
    ) {

        Text(
            modifier = Modifier
                .align(Alignment.CenterStart)
                .padding(start = 16.dp),
            text = title,
            fontWeight = FontWeight.Bold,
            fontSize = 28.sp,
            color = AppColors.White,
        )

        Row(
            modifier = Modifier
                .align(Alignment.CenterEnd),
            verticalAlignment = Alignment.CenterVertically,
        ) {

            IconButton(
                modifier = Modifier
                    .padding(end = 8.dp)
                    .size(36.dp),
                onClick = onSearchClick,
            ) {

                Icon(
                    painter = painterResource(R.drawable.ic_search),
                    contentDescription = null,
                    tint = AppColors.White,
                )
            }

            IconButton(
                modifier = Modifier
                    .padding(end = 8.dp)
                    .size(36.dp),
                onClick = onSettingClick,
            ) {

                Icon(
                    painter = painterResource(R.drawable.ic_settings),
                    contentDescription = null,
                    tint = AppColors.White,
                )
            }
        }
    }
}