Prompt utilizado

Tengo una app Android en Jetpack Compose con Navigation Compose para una
clínica llamada "Clínica Salud+". Tiene 6 pantallas: Home (con drawer lateral),
Mis citas, Historial médico, Perfil del médico, Agendar cita y Confirmación.
La navegación usa un NavController, un sealed class Screen con rutas, y un
ModalNavigationDrawer con 3 destinos. La lógica de navegación, los argumentos
que viajan entre pantallas (doctorId, fecha, hora) y el comportamiento del
drawer deben quedar exactamente igual — SOLO quiero que mejores la presentación
visual.

Aplica una identidad visual de salud/bienestar: paleta principal en tonos
turquesa/verde azulado (#00838F o similar) con acentos en blanco, tarjetas con
esquinas redondeadas y sombra suave, iconografía consistente en todas las
pantallas.

1. HomeScreen: agrega un encabezado con saludo ("Hola, [nombre]") arriba de los
   chips de especialidad. Las tarjetas de médicos deben incluir un avatar
   circular (usa Icons.Default.Person con fondo de color, ya que no hay acceso
   a imágenes reales) además del nombre, especialidad y calificación con
   estrellas visuales (no solo texto).

2. DoctorProfileScreen: rediseña como una tarjeta de perfil más completa, con
   avatar grande centrado, nombre y especialidad destacados, calificación con
   iconos de estrella, y el botón "Agendar cita" con ícono de calendario.

3. AgendarCitaScreen: agrupa visualmente la sección de fecha y la de hora en
   tarjetas separadas, con los chips de selección más grandes y un indicador
   claro de cuál está seleccionado (borde o relleno de color).

4. ConfirmacionScreen: agrega un ícono de check animado o destacado en un
   círculo de color, y presenta el resumen de la cita en un diseño tipo
   "ticket" o "boarding pass" en vez de texto simple.

5. MisCitasScreen: mantén el badge de color por estado (Confirmada=verde,
   Completada=gris) pero rediseña las tarjetas para que sean más visuales,
   con el ícono del médico y una línea divisoria clara entre citas.

6. Drawer: agrega un encabezado con el logo/nombre "Clínica Salud+" y un ícono
   representativo (cruz médica o similar) arriba de los 3 destinos existentes.

No uses imágenes de internet ni URLs externas — usa solo íconos de
material-icons-core (Icons.Default.*) dentro de formas con color, ya que el
proyecto no tiene acceso a internet ni assets locales.

Dame el código Kotlin completo de cada archivo modificado, manteniendo los
mismos nombres de función (HomeScreen, DoctorProfileScreen, AgendarCitaScreen,
ConfirmacionScreen, MisCitasScreen, DrawerScaffold) y las mismas firmas de
parámetros que ya tienen.

Requisitos funcionales/visuales cumplidos
1. Identidad visual de salud (paleta turquesa) aplicada consistentemente en las 6 pantallas
2. Avatares e iconografía médica en tarjetas de doctores y perfil
3. Indicador visual reforzado de selección en fecha/hora (Agendar cita)
4. Rediseño tipo "ticket" en pantalla de Confirmación

Se corrigió el texto del saludo para mostrar "Hola, Luis", manteniendo
el resto de la funcionalidad sin cambios.