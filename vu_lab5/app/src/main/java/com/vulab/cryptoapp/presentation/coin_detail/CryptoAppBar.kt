package com.vulab.cryptoapp.presentation.coin_detail

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun CryptoAppBar(
    title: String = "Title",
    icon: ImageVector? = null,
    elevation: Dp = 0.dp,
    navController: NavController,
    onButtonClicked: () -> Unit = {}
) {
    TopAppBar(
        title = {
            Text(
                text = title,
                color = Color.Green,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.h3,
            )
        },
        navigationIcon = {
            if (icon != null) {
                IconButton(onClick = { onButtonClicked.invoke() }) {
                    Icon(imageVector = icon, contentDescription = null,
                        tint = Color.Green,
                    )
                }
            }
        },
        backgroundColor = Color.Transparent,
        elevation = elevation
    )
}