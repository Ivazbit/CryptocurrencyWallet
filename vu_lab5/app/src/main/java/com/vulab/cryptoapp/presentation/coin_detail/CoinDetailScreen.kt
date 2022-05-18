package com.vulab.cryptoapp.presentation.coin_detail

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController

@Composable
fun CoinDetailScreen(
    viewModel: CoinDetailViewModel = hiltViewModel(),
    navController: NavController,
) {
    val state = viewModel.state.value
    var inputValue by remember { mutableStateOf("") }
    var coinValue by remember { mutableStateOf("") }
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
                        Modifier.padding(PaddingValues(horizontal = 10.dp, vertical = 15.dp))
                    )
                }
                OutlinedTextField(
                    value = inputValue,
                    onValueChange = {
                        inputValue = it
                        coinValue = viewModel.calculatePrice(state.coin, inputValue).toString()
                    },
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
                Text("USD", Modifier.padding(horizontal = 10.dp, vertical = 15.dp))
                Text(
                    text = if (!coinValue.isEmpty()) {
                        "$coinValue $"
                    } else "0.00 $",
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


//        if(state.error.isNotBlank()){
//            Text(
//                text = state.error,
//                color = MaterialTheme.colors.error,
//                textAlign = TextAlign.Center,
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(horizontal = 20.dp)
//                    //.align(Alignment.Center)
//            )
//        }
//        if(state.isLoading){
//            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
//        }
}


