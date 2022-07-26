package com.danielg7.cripto.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Money
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.danielg7.cripto.data.remote.models.Cripto
import com.danielg7.cripto.ui.theme.CriptoTheme
import com.danielg7.cripto.ui.theme.Purple200

@Composable
fun CriptoCard(item: Cripto, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .background(
                Purple200
            ),
        // onClick= onClick
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row() {
            Icon(
                tint = MaterialTheme.colors.onSurface,
                imageVector = Icons.Filled.Money, contentDescription = "Money",
                modifier = Modifier.width(20.dp))
            Spacer(modifier = Modifier.width(10.dp))
            Text(

                text = item.book,
                style = MaterialTheme.typography.h6)
        }
        Row() {
            Icon(imageVector = Icons.Filled.ArrowForward, contentDescription = "Money")
        }
    }

    Spacer(modifier = Modifier.height(10.dp))
}

@Preview("Cripto Button")
@Composable
fun CriptoCardPreview() {
    val item = Cripto(
        book = "BTC",
        minimum_price = 0.00,
        maximum_price = 0.00,
        minimum_amount = 0.00,
        maximum_amount = 0.00,
        minimum_value = 0.00,
        maximum_value = 0.00,
        tick_size = 0.00,
        default_chart = 0.00
    )
    CriptoTheme {
        CriptoCard(item)
    }
}
