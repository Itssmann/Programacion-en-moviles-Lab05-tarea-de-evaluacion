package com.abad.tecsupfit.model

data class ClaseFitness(
    val id: Int,
    val nombre: String,
    val horario: String,
    val dia: String,
    val entrenador: String
)

val clasesMock = listOf(
    ClaseFitness(1, "Spinning", "08:00 AM", "Hoy", "Carlos Ramos"),
    ClaseFitness(2, "Funcional", "10:00 AM", "Hoy", "Andrea López"),
    ClaseFitness(3, "Yoga", "06:00 PM", "Hoy", "María Torres"),
    ClaseFitness(4, "Cross Training", "07:00 PM", "Esta semana", "Luis Vega"),
    ClaseFitness(5, "Zumba", "05:00 PM", "Esta semana", "Sofía Díaz")
)

data class Reserva(
    val id: Int,
    val clase: String,
    val horario: String,
    val estado: String
)

val reservasMock = listOf(
    Reserva(
        id = 1,
        clase = "Spinning",
        horario = "08:00 AM",
        estado = "Confirmada"
    ),
    Reserva(
        id = 2,
        clase = "Yoga",
        horario = "06:00 PM",
        estado = "Completada"
    )
)