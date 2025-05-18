package com.alex.reservaautobuses

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun MainScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {


        Button(
            onClick = { navController.navigate("crearUsuario") },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Crear Usuario")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { navController.navigate("trayectos") },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Ver Trayectos")
        }
    }
}

