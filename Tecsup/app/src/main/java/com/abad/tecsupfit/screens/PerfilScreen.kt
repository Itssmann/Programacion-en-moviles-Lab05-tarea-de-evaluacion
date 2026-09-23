package com.abad.tecsupfit.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.abad.tecsupfit.components.BottomBar

@Composable
fun PerfilScreen(navController: NavController) {

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
                text = "Mi perfil",
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
                        text = "Luis Abad",
                        fontSize = 22.sp
                    )

                    Text(
                        text = "Miembro de TECSUP Fit",
                        modifier = Modifier.padding(top = 6.dp)
                    )
                }
            }

            Text(
                text = "Estadísticas",
                fontSize = 20.sp,
                modifier = Modifier.padding(top = 24.dp)
            )

            Text(
                text = "Clases tomadas: 12",
                modifier = Modifier.padding(top = 12.dp)
            )

            Text(
                text = "Racha de asistencia: 4 días",
                modifier = Modifier.padding(top = 8.dp)
            )
        }
    }
}