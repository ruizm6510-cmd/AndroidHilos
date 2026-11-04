# Walkthrough - Implementación de los 28 Ejercicios de Hilos y Sensores

Se han implementado exitosamente los **28 ejercicios** especificados en la guía de estudio *"6 Android hilos de ejecución y sensores.pdf"*, organizados de forma modular en tres bloques temáticos con su respectivo menú de navegación en la aplicación.

## Cambios Realizados

### Estructura de Navegación Principal
- **`MainActivity.kt` / `activity_main.xml`**: Pantalla de inicio con acceso a los tres bloques de ejercicios.
- **Menús de Bloque**:
  - `ThreadsActivity`: Menú para los ejercicios de Hilos y Corrutinas (1 - 6).
  - `TouchActivity`: Menú para los ejercicios de Eventos Táctiles y Gestos (7 - 18).
  - `SensorsActivity`: Menú para los ejercicios de Sensores Android (19 - 28).

---

### Bloque 1: Hilos y Corrutinas (Ejercicios 1 - 6)
- [Exercise1Activity.kt](file:///C:/Users/lenov/AndroidStudioProjects/Androidhilos/app/src/main/java/com/example/android_hilos/threads/Exercise1Activity.kt): Hilo (`Thread`) que escribe números del 1 al 10 en un `TextView` con retardo de 1s.
- [Exercise2Activity.kt](file:///C:/Users/lenov/AndroidStudioProjects/Androidhilos/app/src/main/java/com/example/android_hilos/threads/Exercise2Activity.kt): `ProgressBar` y `TextView` con carga progresiva de 0 a 100 cada 100 ms.
- [Exercise3Activity.kt](file:///C:/Users/lenov/AndroidStudioProjects/Androidhilos/app/src/main/java/com/example/android_hilos/threads/Exercise3Activity.kt): Tres hilos concurrentes que imprimen números pares, impares y letras del alfabeto simultáneamente.
- [Exercise4Activity.kt](file:///C:/Users/lenov/AndroidStudioProjects/Androidhilos/app/src/main/java/com/example/android_hilos/threads/Exercise4Activity.kt): Clase `MiTarea` ejecutando cálculo matemático asíncrono (suma de N números).
- [Exercise5Activity.kt](file:///C:/Users/lenov/AndroidStudioProjects/Androidhilos/app/src/main/java/com/example/android_hilos/threads/Exercise5Activity.kt): Corrutina imprimiendo mensajes cada segundo durante 5 segundos.
- [Exercise6Activity.kt](file:///C:/Users/lenov/AndroidStudioProjects/Androidhilos/app/src/main/java/com/example/android_hilos/threads/Exercise6Activity.kt): Simulación de sensor con datos aleatorios cada 500 ms mediante corrutina y botón de parada.

---

### Bloque 2: Eventos Táctiles y Gestos (Ejercicios 7 - 18)
- [Exercise7Activity.kt](file:///C:/Users/lenov/AndroidStudioProjects/Androidhilos/app/src/main/java/com/example/android_hilos/touch/Exercise7Activity.kt): Detección de eventos táctiles (`ACTION_DOWN`, `ACTION_MOVE`, `ACTION_UP`).
- [Exercise8Activity.kt](file:///C:/Users/lenov/AndroidStudioProjects/Androidhilos/app/src/main/java/com/example/android_hilos/touch/Exercise8Activity.kt): Visualización en tiempo real de coordenadas X e Y táctiles.
- [Exercise9Activity.kt](file:///C:/Users/lenov/AndroidStudioProjects/Androidhilos/app/src/main/java/com/example/android_hilos/touch/Exercise9Activity.kt): Vista personalizada con cambio aleatorio de color al tocar.
- [Exercise10Activity.kt](file:///C:/Users/lenov/AndroidStudioProjects/Androidhilos/app/src/main/java/com/example/android_hilos/touch/Exercise10Activity.kt): `ImageView` (pelota) arrastrable libremente por la pantalla.
- [Exercise11Activity.kt](file:///C:/Users/lenov/AndroidStudioProjects/Androidhilos/app/src/main/java/com/example/android_hilos/touch/Exercise11Activity.kt): Vista de dibujo libre con almacenamiento de trazos.
- [Exercise12Activity.kt](file:///C:/Users/lenov/AndroidStudioProjects/Androidhilos/app/src/main/java/com/example/android_hilos/touch/Exercise12Activity.kt): Reconocimiento de gestos (`GestureDetector`: Tap, Long Press, Fling).
- [Exercise13Activity.kt](file:///C:/Users/lenov/AndroidStudioProjects/Androidhilos/app/src/main/java/com/example/android_hilos/touch/Exercise13Activity.kt): Detección de múltiples dedos simultáneos y sus posiciones X, Y.
- [Exercise14Activity.kt](file:///C:/Users/lenov/AndroidStudioProjects/Androidhilos/app/src/main/java/com/example/android_hilos/touch/Exercise14Activity.kt): Dibujo multi-dedo simultáneo con colores distintos por dedo.
- [Exercise15Activity.kt](file:///C:/Users/lenov/AndroidStudioProjects/Androidhilos/app/src/main/java/com/example/android_hilos/touch/Exercise15Activity.kt): Pellizco (`ScaleGestureDetector` / Pinch to zoom) en `ImageView`.
- [Exercise16Activity.kt](file:///C:/Users/lenov/AndroidStudioProjects/Androidhilos/app/src/main/java/com/example/android_hilos/touch/Exercise16Activity.kt): Rotación de vista con dos dedos calculando el ángulo de giro.
- [Exercise17Activity.kt](file:///C:/Users/lenov/AndroidStudioProjects/Androidhilos/app/src/main/java/com/example/android_hilos/touch/Exercise17Activity.kt): Puntos de color dinámicos por cada dedo que siguen el movimiento y desaparecen al soltar.
- [Exercise18Activity.kt](file:///C:/Users/lenov/AndroidStudioProjects/Androidhilos/app/src/main/java/com/example/android_hilos/touch/Exercise18Activity.kt): Control avanzado de imagen (Arrastre, Zoom y Rotación combinados).

---

### Bloque 3: Sensores Android (Ejercicios 19 - 28)
- [Exercise19Activity.kt](file:///C:/Users/lenov/AndroidStudioProjects/Androidhilos/app/src/main/java/com/example/android_hilos/sensors/Exercise19Activity.kt): Sensor de proximidad (cambio de fondo rojo/verde).
- [Exercise20Activity.kt](file:///C:/Users/lenov/AndroidStudioProjects/Androidhilos/app/src/main/java/com/example/android_hilos/sensors/Exercise20Activity.kt): Sensor de luz ambiental (`TYPE_LIGHT` en lux).
- [Exercise21Activity.kt](file:///C:/Users/lenov/AndroidStudioProjects/Androidhilos/app/src/main/java/com/example/android_hilos/sensors/Exercise21Activity.kt): Orientación (Acelerómetro + Magnetómetro mediante `getRotationMatrix` y `getOrientation`).
- [Exercise22Activity.kt](file:///C:/Users/lenov/AndroidStudioProjects/Androidhilos/app/src/main/java/com/example/android_hilos/sensors/Exercise22Activity.kt): Brújula magnética con `ImageView` rotando respecto al azimut.
- [Exercise23Activity.kt](file:///C:/Users/lenov/AndroidStudioProjects/Androidhilos/app/src/main/java/com/example/android_hilos/sensors/Exercise23Activity.kt): Movimiento de círculo en pantalla inclinando el dispositivo (Acelerómetro).
- [Exercise24Activity.kt](file:///C:/Users/lenov/AndroidStudioProjects/Androidhilos/app/src/main/java/com/example/android_hilos/sensors/Exercise24Activity.kt): Contador y detector de pasos (`TYPE_STEP_COUNTER` / `TYPE_STEP_DETECTOR`).
- [Exercise25Activity.kt](file:///C:/Users/lenov/AndroidStudioProjects/Androidhilos/app/src/main/java/com/example/android_hilos/sensors/Exercise25Activity.kt): Lógica combinada de proximidad y luz (pantalla negra si oscuro y cerca, blanca si claro y lejos).
- [Exercise26Activity.kt](file:///C:/Users/lenov/AndroidStudioProjects/Androidhilos/app/src/main/java/com/example/android_hilos/sensors/Exercise26Activity.kt): Detector de sacudidas (`shake`) con acelerómetro y umbral de magnitud.
- [Exercise27Activity.kt](file:///C:/Users/lenov/AndroidStudioProjects/Androidhilos/app/src/main/java/com/example/android_hilos/sensors/Exercise27Activity.kt): Detección de posición del dispositivo (boca arriba, boca abajo, vertical).
- [Exercise28Activity.kt](file:///C:/Users/lenov/AndroidStudioProjects/Androidhilos/app/src/main/java/com/example/android_hilos/sensors/Exercise28Activity.kt): Panel multisensores integrando pasos, nivel de movimiento del acelerómetro y datos del giroscopio.

## Resultados de Verificación

### Pruebas de Compilación
- Ejecutado exitosamente `gradle_build` (`app:assembleDebug`).
- **Resultado**: Compilación completada con éxito (`BUILD SUCCESSFUL`).
