package com.alex.reservaautobuses

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController, startDestination = "main") {
        composable("main") { MainScreen(navController) }
        composable("usuarios") { ListaUsuariosScreen(navController) }
        composable("crearUsuario") { CrearUsuarioScreen(navController) }
        composable("trayectos") { ListaTrayectosScreen(navController) }
        composable("asignarAutobus/{trayectoId}") { backStackEntry ->
            val trayectoId = backStackEntry.arguments?.getString("trayectoId")?.toLongOrNull() ?: 0L
            AsignarAutobusScreen(trayectoId, navController)
        }

    }

}

