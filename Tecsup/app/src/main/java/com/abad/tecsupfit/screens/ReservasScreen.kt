package com.abad.tecsupfit.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.abad.tecsupfit.components.BottomBar
import com.abad.tecsupfit.model.Reserva
import com.abad.tecsupfit.model.reservasMock

@Composable
fun ReservasScreen(navController: NavController) {

    Scaffold(
        bottomBar = {
            BottomBar(navController)
        }
    ) { paddingValues ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp)
        ) {

            Text(
                text = "Mis reservas",
                fontSize = 28.sp,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                items(reservasMock) { reserva ->
                    ReservaCard(reserva)
                }
            }
        }
    }
}

@Composable
fun ReservaCard(reserva: Reserva) {

    Card(
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {

            Text(
                text = reserva.clase,
                fontSize = 20.sp
            )

            Text(
                text = "Horario: ${reserva.horario}",
                modifier = Modifier.padding(top = 6.dp)
            )

            Text(
                text = "Estado: ${reserva.estado}",
                modifier = Modifier.padding(top = 6.dp)
            )
        }
    }
}