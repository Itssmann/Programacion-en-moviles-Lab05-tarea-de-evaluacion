package com.abad.tecsupfit.navigation

import android.net.Uri
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.abad.tecsupfit.screens.ConfirmacionScreen
import com.abad.tecsupfit.screens.DetalleClaseScreen
import com.abad.tecsupfit.screens.HomeScreen
import com.abad.tecsupfit.screens.PerfilScreen
import com.abad.tecsupfit.screens.ReservasScreen
import com.abad.tecsupfit.screens.RutinasScreen

@Composable
fun AppNavigation() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {

        composable(Screen.Home.route) {
            HomeScreen(navController)
        }

        composable(Screen.Reservas.route) {
            ReservasScreen(navController)
        }

        composable(Screen.Rutinas.route) {
            RutinasScreen(navController)
        }

        composable(Screen.Perfil.route) {
            PerfilScreen(navController)
        }

        composable(
            route = Screen.DetalleClase.route,
            arguments = listOf(
                navArgument("claseId") {
                    type = NavType.IntType
                }
            )
        ) { backStackEntry ->

            val claseId =
                backStackEntry.arguments?.getInt("claseId") ?: 0

            DetalleClaseScreen(
                navController = navController,
                claseId = claseId
            )
        }

        composable(
            route = Screen.Confirmacion.route,
            arguments = listOf(
                navArgument("claseId") {
                    type = NavType.IntType
                },
                navArgument("horario") {
                    type = NavType.StringType
                }
            )
        ) { backStackEntry ->

            val claseId =
                backStackEntry.arguments?.getInt("claseId") ?: 0

            val horario =
                Uri.decode(
                    backStackEntry.arguments?.getString("horario") ?: ""
                )

            ConfirmacionScreen(
                navController = navController,
                claseId = claseId,
                horario = horario
            )
        }
    }
}