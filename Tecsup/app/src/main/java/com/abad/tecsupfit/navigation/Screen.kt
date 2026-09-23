package com.abad.tecsupfit.navigation

import android.net.Uri

sealed class Screen(val route: String) {

    object Home : Screen("home")

    object Reservas : Screen("reservas")

    object Rutinas : Screen("rutinas")

    object Perfil : Screen("perfil")

    object DetalleClase : Screen("detalle_clase/{claseId}") {
        fun createRoute(claseId: Int): String {
            return "detalle_clase/$claseId"
        }
    }

    object Confirmacion : Screen("confirmacion/{claseId}/{horario}") {
        fun createRoute(claseId: Int, horario: String): String {
            return "confirmacion/$claseId/${Uri.encode(horario)}"
        }
    }
}