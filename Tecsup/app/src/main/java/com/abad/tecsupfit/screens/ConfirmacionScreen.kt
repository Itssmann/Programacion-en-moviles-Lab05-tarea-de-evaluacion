package com.abad.tecsupfit.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.abad.tecsupfit.model.clasesMock
import com.abad.tecsupfit.navigation.Screen

@Composable
fun ConfirmacionScreen(
    navController: NavController,
    claseId: Int,
    horario: String
) {
    val clase = clasesMock.find {
        it.id == claseId
    } ?: return

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Text(
            text = "Reserva confirmada",
            fontSize = 28.sp
        )

        Text(
            text = "¡Tu cupo fue reservado correctamente!",
            modifier = Modifier.padding(top = 8.dp)
        )

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 24.dp)
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    text = clase.nombre,
                    fontSize = 22.sp
                )

                Text(
                    text = "Entrenador: ${clase.entrenador}",
                    modifier = Modifier.padding(top = 8.dp)
                )

                Text(
                    text = "Horario: $horario",
                    modifier = Modifier.padding(top = 8.dp)
                )

                Text(
                    text = "Estado: Confirmada",
                    modifier = Modifier.padding(top = 8.dp)
                )
            }
        }

        Button(
            onClick = {
                navController.navigate(Screen.Reservas.route)
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 24.dp)
        ) {
            Text("Ver mis reservas")
        }
    }
}