package com.alex.reservaautobuses

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.alex.reservaautobuses.ui.theme.ReservaAutobusesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ReservaAutobusesTheme {
                AppContent()
            }
        }
    }
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun AppContent() {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Reserva Autobuses") }
            )
        }
    ) { innerPadding ->
        Surface(modifier = Modifier.padding(innerPadding)) {
            AppNavigation()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ReservaAutobusesTheme {
        AppContent()
    }
}

