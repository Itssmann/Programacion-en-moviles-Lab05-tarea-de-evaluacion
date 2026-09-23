package com.abad.tecsupfit.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.abad.tecsupfit.components.BottomBar

@Composable
fun RutinasScreen(navController: NavController) {

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
                text = "Rutinas",
                fontSize = 28.sp
            )

            Text(
                text = "Tus rutinas de entrenamiento",
                modifier = Modifier.padding(top = 8.dp)
            )

            Text(
                text = "• Cardio - 30 minutos",
                modifier = Modifier.padding(top = 24.dp)
            )

            Text(
                text = "• Fuerza - 45 minutos",
                modifier = Modifier.padding(top = 12.dp)
            )

            Text(
                text = "• Movilidad - 20 minutos",
                modifier = Modifier.padding(top = 12.dp)
            )
        }
    }
}