package com.abad.tecsupfit.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Scaffold
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
import com.abad.tecsupfit.components.BottomBar
import com.abad.tecsupfit.model.ClaseFitness
import com.abad.tecsupfit.model.clasesMock
import com.abad.tecsupfit.navigation.Screen

@Composable
fun HomeScreen(navController: NavController) {

    var filtroSeleccionado by remember {
        mutableStateOf("Hoy")
    }

    val filtros = listOf("Hoy", "Esta semana")

    val clasesFiltradas = clasesMock.filter {
        it.dia == filtroSeleccionado
    }

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
                text = "TECSUP Fit",
                fontSize = 28.sp
            )

            Text(
                text = "Encuentra tu próxima clase",
                modifier = Modifier.padding(
                    top = 4.dp,
                    bottom = 16.dp
                )
            )

            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(filtros) { filtro ->

                    FilterChip(
                        selected = filtroSeleccionado == filtro,
                        onClick = {
                            filtroSeleccionado = filtro
                        },
                        label = {
                            Text(filtro)
                        }
                    )
                }
            }

            Text(
                text = "Clases disponibles",
                fontSize = 20.sp,
                modifier = Modifier.padding(
                    top = 20.dp,
                    bottom = 8.dp
                )
            )

            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                items(clasesFiltradas) { clase ->

                    ClaseCard(
                        clase = clase,
                        onClick = {
                            navController.navigate(
                                Screen.DetalleClase.createRoute(clase.id)
                            )
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun ClaseCard(
    clase: ClaseFitness,
    onClick: () -> Unit
) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                onClick()
            }
    ) {

        Column(
            modifier = Modifier.padding(16.dp)
        ) {

            Text(
                text = clase.nombre,
                fontSize = 20.sp
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = clase.horario)
                Text(text = clase.entrenador)
            }
        }
    }
}