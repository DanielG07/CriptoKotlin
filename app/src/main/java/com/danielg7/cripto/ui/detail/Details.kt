package com.danielg7.cripto.ui.detail

import android.widget.Toast
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.danielg7.cripto.data.remote.models.Cripto
import com.danielg7.cripto.domain.viewmodels.CriptoViewModel
import com.danielg7.cripto.ui.components.AlertInput
import com.danielg7.cripto.utils.getStringByIdName
import com.danielg7.cripto.utils.hasInternetConnection
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class, ExperimentalAnimationApi::class)
@Composable
fun Details(criptoExtra: Cripto?) {
    val context = LocalContext.current
    val vm: CriptoViewModel = hiltViewModel()
    val modalBottomSheetState = rememberModalBottomSheetState(
        initialValue = ModalBottomSheetValue.Hidden
    )
    val uIthread = rememberCoroutineScope()
    val closeSheet = {
        uIthread.launch { modalBottomSheetState.hide() }
    }
    val openSheet = {
        uIthread.launch { modalBottomSheetState.show() }
    }
    if (criptoExtra != null) {

        ModalBottomSheetLayout(
            sheetState = modalBottomSheetState,
            sheetContent = {
                Spacer(modifier = Modifier.height(1.dp))
                AlertInput(
                    title = "Compra Cripto",
                    description = "Ingrese el monto de cripto que quiere comprar.",
                    defaultTextFieldValue = TextFieldValue(""),
                    onPrimary = {
                        vm.buyCripto(
                            onSuccess = {
                                Toast.makeText(context, "Compra exitosa", Toast.LENGTH_SHORT).show()
                                closeSheet()
                            },
                            onError = {
                                Toast.makeText(context, "Compra fallida", Toast.LENGTH_SHORT).show()
                            },
                            refresh = context.hasInternetConnection(),
                            price = it.text.toDouble()
                        )
                    },
                    onSecondary = { closeSheet() },
                    primaryLabel = "Aceptar",
                    secondaryLabel = "Cancelar",
                    defaultTextFieldLabel = context.getStringByIdName(criptoExtra.book) ?: ""
                )
            }
        ) {
            Scaffold(
                topBar = { TopAppBar(title = { Text(text = "Cripto Detail") }) }
            ) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Button(onClick = { openSheet() }) {
                        Text(text = "Button")
                    }
                }
            }
        }
    }
}

@Composable
fun HelloContent() {
    Column(modifier = Modifier.padding(16.dp)) {
        var name by remember { mutableStateOf("") }
        if (name.isNotEmpty()) {
            Text(
                text = "Hello, $name!",
                modifier = Modifier.padding(bottom = 8.dp),
                style = MaterialTheme.typography.h5
            )
        }
        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Name") }
        )
    }
}
