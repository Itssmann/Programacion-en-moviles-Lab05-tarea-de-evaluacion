package com.abad.tecsupfit.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.abad.tecsupfit.model.clasesMock
import com.abad.tecsupfit.navigation.Screen

@Composable
fun DetalleClaseScreen(
    navController: NavController,
    claseId: Int
) {

    val clase = clasesMock.find {
        it.id == claseId
    } ?: return

    val horarios = listOf(
        clase.horario,
        "04:00 PM",
        "07:00 PM"
    )

    var horarioSeleccionado by remember {
        mutableStateOf(clase.horario)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Text(
            text = "Detalle de clase",
            fontSize = 28.sp
        )

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp)
        ) {

            Column(
                modifier = Modifier.padding(16.dp)
            ) {

                Text(
                    text = clase.nombre,
                    fontSize = 24.sp
                )

                Text(
                    text = "Entrenador: ${clase.entrenador}",
                    modifier = Modifier.padding(top = 8.dp)
                )

                Text(
                    text = "Día: ${clase.dia}",
                    modifier = Modifier.padding(top = 4.dp)
                )
            }
        }

        Text(
            text = "Selecciona un horario",
            fontSize = 20.sp,
            modifier = Modifier.padding(
                top = 24.dp,
                bottom = 8.dp
            )
        )

        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {

            items(horarios) { horario ->

                FilterChip(
                    selected = horarioSeleccionado == horario,
                    onClick = {
                        horarioSeleccionado = horario
                    },
                    label = {
                        Text(horario)
                    }
                )
            }
        }

        Button(
            onClick = {
                navController.navigate(
                    Screen.Confirmacion.createRoute(
                        claseId,
                        horarioSeleccionado
                    )
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 24.dp)
        ) {
            Text("Reservar cupo")
        }
    }
}