package com.danielg7.cripto.ui.home

import android.widget.Toast
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.BottomAppBar
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.danielg7.cripto.domain.viewmodels.CriptoViewModel
import com.danielg7.cripto.ui.components.CardCripto
import com.danielg7.cripto.utils.hasInternetConnection
import timber.log.Timber

@Composable
fun Home(navController: NavHostController) {
    val activityContext = LocalContext.current
    val vm: CriptoViewModel = hiltViewModel()

    vm.getCriptos(
        onSuccess = {
            Timber.v(it.size.toString())
        },
        onError = {
            Toast.makeText(activityContext, "Error", Toast.LENGTH_SHORT).show()
        },
        refresh = activityContext.hasInternetConnection()
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Cripto") }
            )
        },
        bottomBar = {
            BottomAppBar { /* Bottom app bar content */ }
        }
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            items(vm.criptos) { item ->
                CardCripto(item = item, onClick = {
                    /*val intent = CriptoDetailsActivity.getIntent(activityContext, item)
                    // val intent = AtmActivity.getIntent(activityContext)
                    activityContext.startActivity(intent)*/
                    navController.navigate("map")
                })
            }
        }
    }
}
