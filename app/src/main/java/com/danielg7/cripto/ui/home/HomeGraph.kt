package com.danielg7.cripto.ui.home

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.danielg7.cripto.ui.atm.Map
import com.danielg7.cripto.ui.detail.Details

@Composable
fun HomeGraph(navController: NavHostController) {

    NavHost(navController = navController, startDestination = "home") {
        composable("home") { Home(navController) }
        composable("map") { Map() }
        composable("descriptionCripto") { Details(criptoExtra = null) }
        /*...*/
    }
}
