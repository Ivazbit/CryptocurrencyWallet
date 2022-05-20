package com.vulab.cryptoapp.presentation.coin_list.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.vulab.cryptoapp.domain.model.CoinData

@Composable
fun CoinListItem(
    coin: CoinData,
    onItemClick: (CoinData) -> Unit,
){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onItemClick(coin) }
            .padding(20.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(horizontalArrangement = Arrangement.SpaceBetween){
            Text(
                text = "${coin.name} (${coin.symbol})",
                style = MaterialTheme.typography.body1,
                fontWeight = FontWeight.Bold,
                overflow = TextOverflow.Ellipsis
            )
            Spacer(Modifier.weight(1f))
            Column(horizontalAlignment = Alignment.End) {
                Text(
                    text = String.format("%s$", calculatePrice(coin.quantity, coin.price_usd)),
                    color = Color.Green,
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.body2,
                )
                Text(
                    text = String.format(coin.quantity.toString()),
                    color = Color.Green,
                    style = MaterialTheme.typography.body2,
                )
            }
        }
    }
}

private fun calculatePrice(coin: Double, valueCoin: Double): String {
    val convertedValue = valueCoin * coin
    return "%.2f".format(convertedValue)
}