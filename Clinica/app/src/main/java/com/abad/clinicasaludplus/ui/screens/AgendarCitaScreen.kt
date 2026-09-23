package com.abad.clinicasaludplus.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.abad.clinicasaludplus.model.Doctor
import com.abad.clinicasaludplus.navigation.Screen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AgendarCitaScreen(doctor: Doctor, navController: NavController) {
    val fechas = remember { listOf("Lun 20 Oct", "Mar 21 Oct", "Mié 22 Oct") }
    val horas = remember { listOf("09:00 am", "11:00 am", "03:00 pm") }

    var fechaSeleccionada by remember { mutableStateOf(fechas.first()) }
    var horaSeleccionada by remember { mutableStateOf(horas.first()) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Agendar cita") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Volver")
                    }
                }
            )
        }
    ) { paddingValues ->
        Column(modifier = Modifier.padding(paddingValues).fillMaxSize().padding(16.dp)) {
            Text("Cita con ${doctor.nombre}", style = MaterialTheme.typography.titleMedium)

            Spacer(modifier = Modifier.height(24.dp))
            Text("Selecciona una fecha", style = MaterialTheme.typography.labelLarge)
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.padding(vertical = 8.dp)
            ) {
                items(fechas) { fecha ->
                    FilterChip(
                        selected = fecha == fechaSeleccionada,
                        onClick = { fechaSeleccionada = fecha },
                        label = { Text(fecha) }
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))
            Text("Selecciona una hora", style = MaterialTheme.typography.labelLarge)
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.padding(vertical = 8.dp)
            ) {
                items(horas) { hora ->
                    FilterChip(
                        selected = hora == horaSeleccionada,
                        onClick = { horaSeleccionada = hora },
                        label = { Text(hora) }
                    )
                }
            }

            Spacer(modifier = Modifier.weight(1f))

            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = {
                    navController.navigate(
                        Screen.Confirmacion.createRoute(doctor.id, fechaSeleccionada, horaSeleccionada)
                    )
                }
            ) {
                Text("Confirmar cita")
            }
        }
    }
}