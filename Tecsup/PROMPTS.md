Prompt utilizado

Tengo una aplicación Android en Jetpack Compose llamada "TECSUP Fit".

Actualmente tiene estas pantallas:
- HomeScreen
- DetalleClaseScreen
- ConfirmacionScreen
- ReservasScreen
- RutinasScreen
- PerfilScreen

La navegación utiliza Navigation Compose, NavController, una sealed class Screen y un BottomBar con 4 pestañas: Inicio, Reservas, Rutinas y Perfil.

IMPORTANTE:
No cambies la lógica de navegación, las rutas, los parámetros claseId y horario, los nombres ni las firmas de las funciones. No uses MVVM ni ViewModel. Mantén remember y mutableStateOf. SOLO quiero mejorar la presentación visual.

Realiza las siguientes mejoras:

1. Aplica una identidad visual deportiva a TECSUP Fit usando Material 3, colores azul oscuro y verde como acento, tarjetas redondeadas y una interfaz moderna.

2. HomeScreen:
- Agrega un encabezado atractivo con el texto "TECSUP Fit".
- Mantén los filtros "Hoy" y "Esta semana".
- Mejora visualmente los FilterChip.
- Mejora las tarjetas de las clases mostrando nombre, horario y entrenador con iconos de Material.

3. DetalleClaseScreen:
- Muestra la información de la clase en una tarjeta destacada.
- Mantén la selección única de horario.
- Haz que el horario seleccionado se diferencie visualmente.
- Mejora el botón "Reservar cupo" con un icono.

4. ConfirmacionScreen:
- Agrega un icono de check destacado para indicar que la reserva fue exitosa.
- Muestra clase, entrenador y horario dentro de una tarjeta de resumen.
- Mantén el botón "Ver mis reservas".

5. ReservasScreen:
- Mejora las tarjetas de reservas.
- Diferencia visualmente los estados:
  "Confirmada" en verde.
  "Completada" en gris.
- Mantén el LazyColumn.

6. RutinasScreen:
- Convierte las rutinas actuales en tarjetas visuales.
- Agrega iconos relacionados con entrenamiento.

7. PerfilScreen:
- Agrega un avatar usando Icons.Default.Person.
- Destaca el nombre del usuario.
- Presenta "Clases tomadas" y "Racha de asistencia" en tarjetas de estadísticas.

8. BottomBar:
- Mejora su presentación visual.
- Mantén exactamente las cuatro pestañas actuales.
- El icono activo debe seguir resaltándose según la pantalla actual.

No utilices imágenes de internet, URLs ni librerías externas.
Utiliza solamente componentes de Jetpack Compose Material 3 e Icons.Default.*.

Correcciones realizadas

Después de implementar el código generado por Gemini, se realizaron pruebas de navegación utilizando el emulador de Android Studio.

Durante las pruebas se detectaron los siguientes problemas:

1. Desde la pantalla Reservas, el botón Inicio del BottomBar no regresaba correctamente a la pantalla principal.

2. La pantalla Detalle de clase no tenía un botón para regresar a la pantalla anterior.

3. La pantalla Confirmación tampoco tenía un botón para regresar.

Para solucionarlo se corrigió la navegación del BottomBar y se agregaron botones de regreso utilizando NavController y popBackStack() en DetalleClaseScreen y ConfirmacionScreen.

