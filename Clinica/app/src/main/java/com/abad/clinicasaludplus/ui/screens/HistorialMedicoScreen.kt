package com.abad.clinicasaludplus.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.abad.clinicasaludplus.model.citasMock
import com.abad.clinicasaludplus.navigation.Screen
import com.abad.clinicasaludplus.ui.components.DrawerScaffold

/**
 * Historial médico: reutiliza las citas ya "Completadas" de citasMock
 * como registro histórico. Es una pantalla simple, principalmente para
 * cumplir el mínimo de 3 destinos del drawer.
 */
@Composable
fun HistorialMedicoScreen(navController: NavController) {
    val historial = citasMock.filter { it.estado == "Completada" }

    DrawerScaffold(
        navController = navController,
        title = "Historial médico",
        currentRoute = Screen.HistorialMedico.route
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier.padding(paddingValues).fillMaxSize().padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(historial) { cita ->
                Card(modifier = Modifier.fillMaxWidth()) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(cita.doctor.nombre, fontWeight = FontWeight.Bold)
                        Text(cita.doctor.especialidad, style = MaterialTheme.typography.bodySmall)
                        Text("Atendido el ${cita.fecha} a las ${cita.hora}")
                    }
                }
            }
        }
    }
}