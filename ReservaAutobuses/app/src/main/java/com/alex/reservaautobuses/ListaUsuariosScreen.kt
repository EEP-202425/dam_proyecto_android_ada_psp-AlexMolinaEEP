package com.alex.reservaautobuses

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import kotlinx.coroutines.launch
import android.widget.Toast

@Composable
fun ListaUsuariosScreen(navController: NavHostController) {
    var usuarios by remember { mutableStateOf<List<Usuario>>(emptyList()) }
    var error by remember { mutableStateOf<String?>(null) }
    val scope = rememberCoroutineScope()
    val context = LocalContext.current

    fun cargarUsuarios() {
        scope.launch {
            try {
                usuarios = RetrofitClient.api.getUsuarios()
                error = null
            } catch (e: Exception) {
                error = "Error al cargar usuarios: ${e.localizedMessage}"
            }
        }
    }

    LaunchedEffect(Unit) {
        cargarUsuarios()
    }

    Column(modifier = Modifier.padding(16.dp)) {
        Button(
            onClick = { navController.navigate("crear") },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Crear nuevo usuario")
        }

        Spacer(modifier = Modifier.height(16.dp))

        if (error != null) {
            Text("Error: $error", color = MaterialTheme.colorScheme.error)
        } else {
            LazyColumn {
                items(usuarios) { usuario ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                    ) {
                        Column(modifier = Modifier.padding(12.dp)) {
                            Text("Nombre: ${usuario.nombre}")
                            Text("Email: ${usuario.email}")
                            Spacer(modifier = Modifier.height(8.dp))
                            Button(
                                onClick = {
                                    scope.launch {
                                        try {
                                            usuario.id?.let { RetrofitClient.api.eliminarUsuario(it) }
                                            Toast.makeText(context, "Usuario eliminado", Toast.LENGTH_SHORT).show()
                                            cargarUsuarios()
                                        } catch (e: Exception) {
                                            Toast.makeText(context, "Error al eliminar: ${e.localizedMessage}", Toast.LENGTH_LONG).show()
                                        }
                                    }
                                }
                            ) {
                                Text("Eliminar")
                            }
                        }
                    }
                }
            }
        }
    }
}

