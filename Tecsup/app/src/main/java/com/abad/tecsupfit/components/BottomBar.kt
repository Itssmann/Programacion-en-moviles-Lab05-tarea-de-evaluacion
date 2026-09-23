package com.abad.tecsupfit.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.abad.tecsupfit.navigation.Screen

@Composable
fun BottomBar(navController: NavController) {

    val currentRoute =
        navController.currentBackStackEntryAsState().value?.destination?.route

    val items = listOf(
        Triple(Screen.Home, "Inicio", Icons.Default.Home),
        Triple(Screen.Reservas, "Reservas", Icons.Default.List),
        Triple(Screen.Rutinas, "Rutinas", Icons.Default.Star),
        Triple(Screen.Perfil, "Perfil", Icons.Default.Person)
    )

    NavigationBar {
        items.forEach { (screen, title, icon) ->

            NavigationBarItem(
                selected = currentRoute == screen.route,

                onClick = {
                    if (currentRoute != screen.route) {
                        navController.navigate(screen.route) {
                            popUpTo(Screen.Home.route) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                },

                icon = {
                    Icon(
                        imageVector = icon,
                        contentDescription = title
                    )
                },

                label = {
                    Text(title)
                }
            )
        }
    }
}