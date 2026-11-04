# Implementación de los 28 Ejercicios de Hilos y Sensores en Android

Implementar los 28 ejercicios prácticos especificados en la guía de estudio "6 Android hilos de ejecución y sensores.pdf" dentro de este proyecto Android (`Android-hilos`).

## User Review Required

> [!IMPORTANT]
> Los 28 ejercicios se organizarán de manera modular y limpia en el proyecto mediante una pantalla principal (menú de navegación o pestañas/tarjetas) que permita acceder a cada uno de los ejercicios (o agruparlos por categorías: Hilos/Corrutinas, Eventos Táctiles/Gestos, y Sensores).

## Open Questions

- ¿Prefiere una interfaz con un menú principal (RecyclerView / LazyColumn) que liste los 28 ejercicios y abra una actividad o fragmento/pantalla para cada uno, o pantallas organizadas por categorías? (Se propondrá un menú principal con categorías para facilitar la navegación y prueba de los 28 ejercicios).

## Proposed Changes

### Estructura de Componentes

#### [NEW] [Exercise Menu & Categories](file:///C:/Users/lenov/AndroidStudioProjects/Androidhilos/app/src/main/java/com/example/android_hilos/ui/)
- Pantalla principal con un menú estructurado para seleccionar y ejecutar cada uno de los 28 ejercicios.

#### [NEW] [Ejercicios 1 - 6: Hilos y Corrutinas](file:///C:/Users/lenov/AndroidStudioProjects/Androidhilos/app/src/main/java/com/example/android_hilos/exercises/threads/)
- **Ejercicio 1**: Hilo (`Thread`) que escribe números del 1 al 10 en un `TextView` con retardo de 1 segundo.
- **Ejercicio 2**: `ProgressBar` y `TextView` con carga progresiva (0-100) simulada por hilo cada 100 ms.
- **Ejercicio 3**: Tres hilos concurrentes (pares, impares, letras del alfabeto).
- **Ejercicio 4**: Clase `MiTarea` realizando operación matemática con cálculo asíncrono.
- **Ejercicio 5**: Botón que lanza corrutina imprimiendo mensajes cada segundo durante 5 segundos.
- **Ejercicio 6**: Simulación de sensor con datos aleatorios cada 500 ms usando corrutinas y botón de parada.

#### [NEW] [Ejercicios 7 - 18: Táctil y Gestos](file:///C:/Users/lenov/AndroidStudioProjects/Androidhilos/app/src/main/java/com/example/android_hilos/exercises/touch/)
- **Ejercicio 7**: Eventos táctiles (`ACTION_DOWN`, `ACTION_MOVE`, `ACTION_UP`) en `TextView`.
- **Ejercicio 8**: Mostrar coordenadas X e Y del punto táctil.
- **Ejercicio 9**: Vista personalizada con cambio de color de fondo al tocarla.
- **Ejercicio 10**: `ImageView` (pelota) arrastrable libremente por la pantalla.
- **Ejercicio 11**: Vista de dibujo libre (pincel y trazos almacenados).
- **Ejercicio 12**: `GestureDetector` para tap, long press y fling.
- **Ejercicio 13**: Detección de múltiples dedos en pantalla y posiciones X e Y en tiempo real.
- **Ejercicio 14**: Dibujo simultáneo con varios dedos con colores distintos.
- **Ejercicio 15**: Pellizco (`pinch`) para acercar/alejar `ImageView`.
- **Ejercicio 16**: Rotación de vista con dos dedos (ángulo de rotación).
- **Ejercicio 17**: Lienzo con puntos de color por cada dedo al arrastrar y desaparición al soltar.
- **Ejercicio 18**: Control completo de imagen (arrastre, zoom/pinch y rotación).

#### [NEW] [Ejercicios 19 - 28: Sensores Android](file:///C:/Users/lenov/AndroidStudioProjects/Androidhilos/app/src/main/java/com/example/android_hilos/exercises/sensors/)
- **Ejercicio 19**: Sensor de proximidad para cambiar color de fondo (rojo cerca, verde lejos).
- **Ejercicio 20**: Sensor de luz ambiental (`TYPE_LIGHT`) mostrando luxes y cambiando brillo/fondo.
- **Ejercicio 21**: Orientación con acelerómetro + magnetómetro (`getRotationMatrix`, `getOrientation`).
- **Ejercicio 22**: Brújula magnética con `ImageView` rotando según el azimut.
- **Ejercicio 23**: Mover círculo (`ImageView`) inclinando el dispositivo con acelerómetro.
- **Ejercicio 24**: Contador/detector de pasos (`TYPE_STEP_DETECTOR` / `TYPE_STEP_COUNTER`).
- **Ejercicio 25**: Combinación de proximidad y luz ambiental (negro si oscuro y cerca, blanco si claro y lejos).
- **Ejercicio 26**: Detector de sacudidas (`shake`) con acelerómetro y magnitud de vector de aceleración.
- **Ejercicio 27**: Detector de posición del dispositivo (boca arriba, boca abajo, vertical).
- **Ejercicio 28**: Panel multisensores (pasos, nivel de movimiento, orientación promedio).

## Verification Plan

### Automated Tests
- Compilación del proyecto (`gradle_build`) para asegurar que no hay errores de sintaxis ni de dependencias.
- Pruebas unitarias básicas para lógica de hilos/tareas.

### Manual Verification
- Compilar y desplegar en emulador o dispositivo físico Android para verificar cada uno de los bloques (Hilos, Táctil/Gestos y Sensores simulados/reales).
