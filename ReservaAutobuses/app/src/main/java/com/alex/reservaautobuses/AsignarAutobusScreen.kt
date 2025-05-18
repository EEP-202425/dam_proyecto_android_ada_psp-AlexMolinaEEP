package com.alex.reservaautobuses

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AsignarAutobusScreen(trayectoId: Long, navController: NavController) {
    val context = LocalContext.current
    val scope = rememberCoroutineScope()

    var autobuses by remember { mutableStateOf<List<Autobus>>(emptyList()) }
    var autobusSeleccionado by remember { mutableStateOf<Autobus?>(null) }
    var expanded by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        scope.launch {
            try {
                autobuses = RetrofitClient.api.getAutobuses()
            } catch (e: Exception) {
                Toast.makeText(context, "Error al cargar autobuses", Toast.LENGTH_SHORT).show()
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Asignar Autobús", style = MaterialTheme.typography.headlineSmall)
        Spacer(modifier = Modifier.height(16.dp))

        ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = { expanded = !expanded }
        ) {
            OutlinedTextField(
                value = autobusSeleccionado?.matricula ?: "Selecciona un autobús",
                onValueChange = {},
                readOnly = true,
                modifier = Modifier.menuAnchor().fillMaxWidth(),
                label = { Text("Autobús") }
            )
            ExposedDropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                autobuses.forEach { autobus ->
                    DropdownMenuItem(
                        text = { Text("${autobus.matricula} (${autobus.modelo})") },
                        onClick = {
                            autobusSeleccionado = autobus
                            expanded = false
                        }
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        Button(onClick = {
            scope.launch {
                if (autobusSeleccionado?.id != null) {
                    try {
                        RetrofitClient.api.asignarAutobus(trayectoId, autobusSeleccionado!!)
                        Toast.makeText(context, "Autobús asignado", Toast.LENGTH_SHORT).show()
                        navController.popBackStack()
                    } catch (e: Exception) {
                        Toast.makeText(context, "Error al asignar", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    Toast.makeText(context, "Selecciona un autobús", Toast.LENGTH_SHORT).show()
                }
            }
        }) {
            Text("Asignar")
        }
    }
}

