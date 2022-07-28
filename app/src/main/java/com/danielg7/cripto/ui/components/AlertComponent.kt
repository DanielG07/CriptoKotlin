package com.danielg7.cripto.ui.components

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalComposeUiApi::class)
@ExperimentalAnimationApi
@Composable
fun AlertInput(
    title: String,
    description: String,
    note: String = "",
    errorMessage: String = "",
    loading: Boolean = false,
    defaultTextFieldValue: TextFieldValue,
    onPrimary: (textInputValue: TextFieldValue) -> Unit,
    onSecondary: () -> Unit,
    primaryLabel: String,
    secondaryLabel: String,
    defaultTextFieldLabel: String
) {
    var kilometers by remember { mutableStateOf(defaultTextFieldValue) }
    val keyboardController = LocalSoftwareKeyboardController.current
    Box(
        Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp)
    ) {
        Column {
            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp)
            ) {
                Text(
                    style = MaterialTheme.typography.h6,
                    text = title
                )
            }
            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.body1,
                    text = description
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            Row(
                modifier = Modifier
                    .height(24.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                if (loading) {
                    CircularProgressIndicator(
                        modifier = Modifier.size(24.dp),
                        color = MaterialTheme.colors.secondary
                    )
                }
            }
            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(horizontalAlignment = Alignment.Start) {
                    TextField(
                        value = kilometers,
                        singleLine = true,
                        modifier = Modifier
                            .height(56.dp)
                            .width(340.dp),
                        onValueChange = { newText ->
                            kilometers = newText
                        },
                        keyboardActions = KeyboardActions(
                            onDone = { keyboardController?.hide() }),
                        keyboardOptions = KeyboardOptions.Default.copy(
                            autoCorrect = true,
                            keyboardType = KeyboardType.Number,
                            imeAction = ImeAction.Done
                        ),
                        label = { Text(defaultTextFieldLabel) }
                    )
                    Text(
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.body1,
                        color = MaterialTheme.colors.error,
                        text = errorMessage
                    )
                }
            }
            Spacer(modifier = Modifier.height(10.dp))
            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                OutlinedButton(
                    onClick = {
                        onPrimary(kilometers)
                    },
                    border = BorderStroke(1.dp, MaterialTheme.colors.primary),
                    shape = CircleShape,
                    modifier = Modifier.width(160.dp)
                ) {
                    Text(
                        color = MaterialTheme.colors.onSurface,
                        text = primaryLabel
                    )
                }
                Spacer(modifier = Modifier.width(8.dp))
                Button(
                    shape = CircleShape,
                    onClick = { onSecondary() },
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = MaterialTheme.colors.primary
                    ),
                    modifier = Modifier.width(160.dp)
                ) {
                    Text(
                        text = secondaryLabel,
                        color = MaterialTheme.colors.onPrimary
                    )
                }
            }
            Spacer(modifier = Modifier.height(40.dp))
        }
    }
}
