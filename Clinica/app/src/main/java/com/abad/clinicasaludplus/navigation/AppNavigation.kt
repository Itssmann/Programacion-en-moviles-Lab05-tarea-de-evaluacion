package com.abad.clinicasaludplus.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.abad.clinicasaludplus.model.doctoresMock
import com.abad.clinicasaludplus.ui.screens.*

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.Home.route) {

        composable(Screen.Home.route) {
            HomeScreen(navController = navController)
        }

        composable(Screen.MisCitas.route) {
            MisCitasScreen(navController = navController)
        }

        composable(Screen.HistorialMedico.route) {
            HistorialMedicoScreen(navController = navController)
        }

        composable(
            route = Screen.DoctorProfile.route,
            arguments = listOf(navArgument("doctorId") { type = NavType.IntType })
        ) { backStackEntry ->
            val doctorId = backStackEntry.arguments?.getInt("doctorId") ?: -1
            doctoresMock.find { it.id == doctorId }?.let { doctor ->
                DoctorProfileScreen(doctor = doctor, navController = navController)
            }
        }

        composable(
            route = Screen.AgendarCita.route,
            arguments = listOf(navArgument("doctorId") { type = NavType.IntType })
        ) { backStackEntry ->
            val doctorId = backStackEntry.arguments?.getInt("doctorId") ?: -1
            doctoresMock.find { it.id == doctorId }?.let { doctor ->
                AgendarCitaScreen(doctor = doctor, navController = navController)
            }
        }

        composable(
            route = Screen.Confirmacion.route,
            arguments = listOf(
                navArgument("doctorId") { type = NavType.IntType },
                navArgument("fecha") { type = NavType.StringType },
                navArgument("hora") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val doctorId = backStackEntry.arguments?.getInt("doctorId") ?: -1
            val fecha = backStackEntry.arguments?.getString("fecha") ?: ""
            val hora = backStackEntry.arguments?.getString("hora") ?: ""
            doctoresMock.find { it.id == doctorId }?.let { doctor ->
                ConfirmacionScreen(doctor = doctor, fecha = fecha, hora = hora, navController = navController)
            }
        }
    }
}