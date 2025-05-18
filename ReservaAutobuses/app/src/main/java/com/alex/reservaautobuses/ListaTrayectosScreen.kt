package com.alex.reservaautobuses

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.navigation.NavController
import androidx.compose.ui.platform.LocalLifecycleOwner
import kotlinx.coroutines.launch

@Composable
fun ListaTrayectosScreen(navController: NavController) {
    val scope = rememberCoroutineScope()
    var trayectos by remember { mutableStateOf<List<Trayecto>>(emptyList()) }
    var error by remember { mutableStateOf<String?>(null) }

    fun recargar() {
        scope.launch {
            try {
                trayectos = RetrofitClient.api.getTrayectos()
                error = null
            } catch (e: Exception) {
                error = e.localizedMessage
            }
        }
    }

    LaunchedEffect(Unit) {
        recargar()
    }

    val lifecycleOwner = LocalLifecycleOwner.current
    DisposableEffect(lifecycleOwner) {
        val observer = LifecycleEventObserver { _, event ->
            if (event == Lifecycle.Event.ON_RESUME) {
                recargar()
            }
        }
        lifecycleOwner.lifecycle.addObserver(observer)
        onDispose {
            lifecycleOwner.lifecycle.removeObserver(observer)
        }
    }

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text("Trayectos", style = MaterialTheme.typography.headlineSmall)
            Button(onClick = { recargar() }) {
                Text("Actualizar")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        if (error != null) {
            Text("Error: $error", color = MaterialTheme.colorScheme.error)
        } else {
            LazyColumn {
                items(trayectos) { trayecto ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 6.dp)
                            .clickable {
                                navController.navigate("asignarAutobus/${trayecto.id}")
                            }
                    ) {
                        Column(modifier = Modifier.padding(16.dp)) {
                            Text("Origen: ${trayecto.origen}")
                            Text("Destino: ${trayecto.destino}")
                            Text("Fecha: ${trayecto.fechaHora}")
                            Text("Autobús: ${trayecto.autobus?.matricula}")
                        }
                    }
                }
            }
        }
    }
}




