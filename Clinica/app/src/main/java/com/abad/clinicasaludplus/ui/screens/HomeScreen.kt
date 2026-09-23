package com.abad.clinicasaludplus.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.abad.clinicasaludplus.model.Doctor
import com.abad.clinicasaludplus.model.doctoresMock
import com.abad.clinicasaludplus.navigation.Screen
import com.abad.clinicasaludplus.ui.components.DrawerScaffold

@Composable
fun HomeScreen(navController: NavController) {
    val especialidades = remember {
        listOf("Todas") + doctoresMock.map { it.especialidad }.distinct()
    }
    var especialidadSeleccionada by remember { mutableStateOf(especialidades.first()) }

    val medicosFiltrados = if (especialidadSeleccionada == "Todas") {
        doctoresMock
    } else {
        doctoresMock.filter { it.especialidad == especialidadSeleccionada }
    }

    DrawerScaffold(
        navController = navController,
        title = "Clínica Salud+",
        currentRoute = Screen.Home.route
    ) { paddingValues ->
        Column(modifier = Modifier.padding(paddingValues).fillMaxSize()) {
            LazyRow(
                modifier = Modifier.fillMaxWidth().padding(vertical = 12.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                contentPadding = PaddingValues(horizontal = 16.dp)
            ) {
                items(especialidades) { especialidad ->
                    FilterChip(
                        selected = especialidad == especialidadSeleccionada,
                        onClick = { especialidadSeleccionada = especialidad },
                        label = { Text(especialidad) }
                    )
                }
            }

            LazyColumn(
                modifier = Modifier.fillMaxSize().padding(horizontal = 16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(medicosFiltrados) { doctor ->
                    DoctorCard(doctor = doctor) {
                        navController.navigate(Screen.DoctorProfile.createRoute(doctor.id))
                    }
                }
            }
        }
    }
}

@Composable
private fun DoctorCard(doctor: Doctor, onClick: () -> Unit) {
    Card(modifier = Modifier.fillMaxWidth().clickable { onClick() }) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(doctor.nombre, fontWeight = FontWeight.Bold, style = MaterialTheme.typography.titleMedium)
            Spacer(modifier = Modifier.height(4.dp))
            Text(doctor.especialidad, style = MaterialTheme.typography.bodyMedium)
            Spacer(modifier = Modifier.height(4.dp))
            Text(" ${doctor.calificacion}", style = MaterialTheme.typography.bodySmall)
        }
    }
}