package com.vulab.cryptoapp.presentation.coin_detail

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.vulab.cryptoapp.R

@Composable
fun CoinDetailScreen(
    viewModel: CoinDetailViewModel = hiltViewModel(),
    navController: NavController,
) {
    val state = viewModel.state.value
    var inputValue by rememberSaveable { mutableStateOf("") }
    Scaffold(topBar = {
        CryptoAppBar(
            navController = navController, title = "${state.coin?.name} (${state.coin?.symbol})",
            icon = Icons.Default.ArrowBack
        ) { navController.popBackStack() }
    }) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 10.dp, vertical = 15.dp)
        ) {
            Spacer(modifier = Modifier.height(30.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                state.coin?.symbol?.let {
                    Text(
                        text = it,
                        Modifier.padding(PaddingValues(horizontal = 10.dp, vertical = 15.dp)),
                        fontWeight = FontWeight.Bold
                    )
                }
                OutlinedTextField(
                    value = inputValue,
                    onValueChange = {
                        inputValue = if (it.isEmpty()){
                            it
                        } else {
                            when (it.toDoubleOrNull()) {
                                null -> inputValue
                                else -> it
                            }
                        }
                    },
                    singleLine = true,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 10.dp, vertical = 15.dp),
                    placeholder = {
                        Text("0.00", style = MaterialTheme.typography.body1)
                    },
                    keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number)
                )
            }
            Spacer(modifier = Modifier.height(30.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    stringResource(R.string.usd),
                    Modifier.padding(horizontal = 10.dp, vertical = 15.dp),
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = if (inputValue.isEmpty()) {
                        "0.00$"
                    }
                    else "${viewModel.calculatePrice(state.coin, inputValue)}$",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 10.dp, vertical = 15.dp),
                    color = Color.Green,
                    style = MaterialTheme.typography.body1
                )
            }
            Spacer(modifier = Modifier.height(15.dp))
        }

    }
    if (state.error.isNotBlank()) {
        Text(
            text = state.error,
            color = MaterialTheme.colors.error,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
        )
    }
    if (state.isLoading) {
        CircularProgressIndicator()
    }
}


