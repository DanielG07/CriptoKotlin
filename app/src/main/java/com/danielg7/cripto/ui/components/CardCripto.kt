package com.danielg7.cripto.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material.icons.filled.Payments
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.danielg7.cripto.data.remote.models.Cripto
import com.danielg7.cripto.ui.theme.BlueGray400
import com.danielg7.cripto.ui.theme.CriptoTheme
import com.danielg7.cripto.utils.getStringByIdName

@Composable
fun CardCripto(item: Cripto) {
    val context = LocalContext.current

    Spacer(modifier = Modifier.height(4.dp))
    Surface(
        shape = RoundedCornerShape(
            topStart = 16.dp,
            topEnd = 16.dp,
            bottomStart = 16.dp,
            bottomEnd = 16.dp
        )

    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp)
                .background(BlueGray400)
                .padding(4.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row() {
                Icon(
                    tint = MaterialTheme.colors.onSurface,
                    imageVector = Icons.Filled.Payments,
                    contentDescription = "IconCurrency"
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    style = MaterialTheme.typography.body1,
                    fontWeight = FontWeight.Bold,
                    text = "${context.getStringByIdName(item.book)}"
                )
            }
            Icon(
                imageVector = Icons.Filled.ChevronRight,
                contentDescription = "ArrowDescription"
            )
        }
    }
}

@Preview("CardCripto")
@Composable
fun CardCriptoPreview() {
    val item = Cripto(
        book = "BTC",
        minimum_price = 0.00,
        maximum_price = 0.00,
        minimum_amount = 0.00,
        maximum_amount = 0.00,
        minimum_value = 0.00,
        maximum_value = 0.00,
        tick_size = 0.00,
        default_chart = "BTC",
        fees = null
    )
    CriptoTheme {
        CardCripto(item)
    }
}

@Preview("CardCripto - Dark")
@Composable
fun CardCriptoPreviewDark() {
    val item = Cripto(
        book = "BTC",
        minimum_price = 0.00,
        maximum_price = 0.00,
        minimum_amount = 0.00,
        maximum_amount = 0.00,
        minimum_value = 0.00,
        maximum_value = 0.00,
        tick_size = 0.00,
        default_chart = "BTC",
        fees = null
    )
    CriptoTheme(darkTheme = true) {
        CardCripto(item)
    }
}
