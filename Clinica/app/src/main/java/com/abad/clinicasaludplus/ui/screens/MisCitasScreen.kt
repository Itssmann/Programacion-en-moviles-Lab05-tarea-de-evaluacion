package com.abad.clinicasaludplus.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.abad.clinicasaludplus.model.Cita
import com.abad.clinicasaludplus.model.citasMock
import com.abad.clinicasaludplus.navigation.Screen
import com.abad.clinicasaludplus.ui.components.DrawerScaffold

@Composable
fun MisCitasScreen(navController: NavController) {
    DrawerScaffold(
        navController = navController,
        title = "Mis citas",
        currentRoute = Screen.MisCitas.route
    ) { paddingValues ->
        if (citasMock.isEmpty()) {
            Box(
                modifier = Modifier.padding(paddingValues).fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text("Aún no tienes citas agendadas")
            }
        } else {
            LazyColumn(
                modifier = Modifier.padding(paddingValues).fillMaxSize().padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(citasMock) { cita ->
                    CitaCard(cita)
                }
            }
        }
    }
}

@Composable
private fun CitaCard(cita: Cita) {
    Card(modifier = Modifier.fillMaxWidth()) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(cita.doctor.nombre, fontWeight = FontWeight.Bold)
            Text(cita.doctor.especialidad, style = MaterialTheme.typography.bodySmall)
            Spacer(modifier = Modifier.height(4.dp))
            Text("${cita.fecha} · ${cita.hora}")
            Spacer(modifier = Modifier.height(8.dp))
            EstadoBadge(estado = cita.estado)
        }
    }
}

/**
 * Diferenciación visual del estado, tal como pide el requisito:
 * verde para "Confirmada", gris para "Completada".
 */
@Composable
private fun EstadoBadge(estado: String) {
    val color = if (estado == "Confirmada") {
        Color(0xFF2E7D32) // verde
    } else {
        Color(0xFF616161) // gris
    }
    Box(
        modifier = Modifier
            .background(color = color.copy(alpha = 0.15f), shape = RoundedCornerShape(8.dp))
            .padding(horizontal = 10.dp, vertical = 4.dp)
    ) {
        Text(
            text = estado,
            color = color,
            style = MaterialTheme.typography.labelMedium,
            fontWeight = FontWeight.Bold
        )
    }
}