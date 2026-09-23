package com.abad.clinicasaludplus.model
data class Doctor(
    val id: Int,
    val nombre: String,
    val especialidad: String,
    val calificacion: Float
)

val doctoresMock = listOf(
    Doctor(1, "Dra. María Fernández", "Cardiología", 4.8f),
    Doctor(2, "Dr. Carlos Ramírez", "Pediatría", 4.6f),
    Doctor(3, "Dra. Lucía Torres", "Dermatología", 4.9f),
    Doctor(4, "Dr. Jorge Salinas", "Cardiología", 4.5f),
    Doctor(5, "Dra. Rosa Medina", "Pediatría", 4.7f)
)

data class Cita(
    val doctor: Doctor,
    val fecha: String,
    val hora: String,
    val estado: String = "Confirmada"
)

// Citas de ejemplo para la pantalla "Mis citas" (no hay ViewModel/persistencia
// en esta fase, así que se muestran como datos fijos de demostración).
val citasMock = listOf(
    Cita(doctoresMock[0], "Lun 20 Oct", "09:00 am"),
    Cita(doctoresMock[2], "Mié 22 Oct", "11:00 am", estado = "Completada")
)