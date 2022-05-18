package com.vulab.cryptoapp.presentation.coin_list.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.vulab.cryptoapp.domain.model.Coin
import com.vulab.cryptoapp.presentation.ui.theme.CryptoTheme

@Composable
fun CoinListItem(
    coin: Coin,
    onItemClick: (Coin) -> Unit
){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onItemClick(coin) }
            .padding(20.dp),

        //kad butu tarpas tarp teksto elementu
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column{
            Text(
                text = "${coin.name} (${coin.symbol})",
                style = MaterialTheme.typography.body1,
                //jei tekstas buna per didelis, ji sutrumpina
                overflow = TextOverflow.Ellipsis
            )
            Text(
                text = String.format("%s$",coin.price_usd),
                color = Color.Green,
                fontStyle = FontStyle.Italic,
                style = MaterialTheme.typography.body2,
            )
        }

    }
}

@Composable
@Preview
fun PreviewCoinListItem(){
    CryptoTheme {

    }
}