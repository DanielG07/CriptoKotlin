package com.danielg7.cripto.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.danielg7.cripto.ui.theme.CriptoTheme

@Composable
fun Card() {
    Surface(
        shape = RoundedCornerShape(topStart = 16.dp, bottomStart = 16.dp)
    ) {
        Row(
            modifier = Modifier
                .height(100.dp)
                .fillMaxWidth()
                .background(Color(0xffffffff)),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .width(100.dp)
                    .background(Color(0xfff44335)),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "1",
                    style = MaterialTheme.typography.caption,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Tareas",
                    style = MaterialTheme.typography.caption
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "5",
                    style = MaterialTheme.typography.caption,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Productos",
                    style = MaterialTheme.typography.caption
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .width(200.dp)
                    .padding(4.dp, 0.dp, 0.dp, 0.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = "Roma norte",
                    style = MaterialTheme.typography.body1,
                    fontWeight = FontWeight.Bold
                )
                Row() {
                    Text(
                        text = "Tipo: ",
                        style = MaterialTheme.typography.caption,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "Complemento",
                        style = MaterialTheme.typography.caption
                    )
                }

                Row() {
                    Text(
                        text = "Hora llegada: ",
                        style = MaterialTheme.typography.caption,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "23:46 hrs",
                        style = MaterialTheme.typography.caption
                    )
                }
            }
        }
    }

}

@Preview("Card")
@Composable
fun CardPreview() {
    CriptoTheme {
        Card()
    }
}

@Preview("Card - Dark")
@Composable
fun CardPreviewDark() {
    CriptoTheme(darkTheme = true) {
        Card()
    }
}