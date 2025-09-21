# Libro ED (Java)

Proyecto base con múltiples ejemplos de Estructuras de Datos en Java (consola y Swing), organizados por capítulos y con persistencia en archivo cuando aplica.

## Requisitos
- Java 17 o superior
- Windows (las apps con persistencia escriben en `C:\Prueba`)

## Estructura general de paquetes
```
src/main/java/com/example/libroed/
  capituloUno/...
  capituloDos/...
  capituloTres/...
  capituloCuatro/...
  capituloCinco/...
  capituloSies/...          (capítulo Seis)
  capituloSiete/...
  capituloOcho/...
```

Notas importantes
- Algunas aplicaciones Swing guardan/leen datos en `C:\Prueba`. Crea la carpeta antes de ejecutar:
  ```powershell
  New-Item -ItemType Directory -Path C:\Prueba -Force
  ```
- Para compilar/ejecutar un ejemplo individual sin Maven:
  ```powershell
  # Compilar (ajusta la ruta al paquete del ejemplo)
  javac -d target\classes src\main\java\com\example\libroed\<ruta_del_paquete>\*.java
  
  # Ejecutar (ajusta el nombre de la clase con main)
  java -cp target\classes com.example.libroed.<ruta_del_paquete>.<ClaseMain>
  ```

## Índice de ejemplos y cómo ejecutarlos

### Capítulo 2 (Listas Enlazadas Simples)
- Temperaturas (consola):
  ```
  Paquete: capituloDos.ejemplos.ej2_2
  Main:    TemperaturasLSE
  ```
- Tren LSE (Swing):
  ```
  Paquete: capituloDos.ejemplos.ej2_3
  Main:    TrenLSE
  ```
- Concesionario LSE (Swing + archivo en C:\\Prueba):
  ```
  Paquete: capituloDos.ejemplos.ej2_4
  Main:    ConcesionarioLSE
  ```

### Capítulo 3 (Pilas)
- TestPila (consola):
  ```
  Paquete: capituloTres.ejemplos.ej3_1
  Main:    TestPila
  ```
- Discos en Pila (consola):
  ```
  Paquete: capituloTres.ejemplos.ej3_2
  Main:    DiscosPila
  ```
- Camisas en Pila (Swing):
  ```
  Paquete: capituloTres.ejemplos.ej3_3
  Main:    CamisasPila
  ```
- Servicios en Pila (Swing + archivo en C:\\Prueba):
  ```
  Paquete: capituloTres.ejemplos.ej3_4
  Main:    ServiciosPila
  ```

### Capítulo 4 (Colas)
- TestCola (consola):
  ```
  Paquete: capituloCuatro.ejemplos.ej4_1
  Main:    TestCola
  ```
- Clientes en Cola (consola):
  ```
  Paquete: capituloCuatro.ejemplos.ej4_2
  Main:    ClientesCola
  ```
- Mantenimientos en Cola (Swing):
  ```
  Paquete: capituloCuatro.ejemplos.ej4_3
  Main:    MantenimientosCola
  ```
- Recursos en Cola (Swing + archivo en C:\\Prueba):
  ```
  Paquete: capituloCuatro.ejemplos.ej4_4
  Main:    RecursosCola
  ```

### Capítulo 5 (Listas Doblemente Enlazadas)
- Palabras LDE (consola):
  ```
  Paquete: capituloCinco.ejemplos.ej5_2
  Main:    PalabrasLDE
  ```
- Word (Deshacer/Rehacer) LDE (Swing):
  ```
  Paquete: capituloCinco.ejemplos.ej5_3
  Main:    WordLDE
  ```
- Navegador LDE (Swing + archivo en C:\\Prueba):
  ```
  Paquete: capituloCinco.ejemplos.ej5_4
  Main:    NavegadorLDE
  ```

### Capítulo 6 (Listas Circulares) — paquete `capituloSies`
- TestLC (consola):
  ```
  Paquete: capituloSies.ejemplos.ej6_1
  Main:    TestLC
  ```
- Ruleta LC (consola):
  ```
  Paquete: capituloSies.ejemplos.ej6_2
  Main:    TestLC
  ```
- Ronda LC (Swing):
  ```
  Paquete: capituloSies.ejemplos.ej6_3
  Main:    RondaLC
  ```
- Carrusel LC (Swing + archivo en C:\\Prueba):
  ```
  Paquete: capituloSies.ejemplos.ej6_4
  Main:    CarruselLC
  ```

### Capítulo 7 (Árboles)
- Recorridos AB (pre/in/post) 7_1:
  ```
  Paquete: capituloSiete.ejemplos.ej7_1
  Main:    TestRecorridosAB
  ```
- Recorridos AB 7_2:
  ```
  Paquete: capituloSiete.ejemplos.ej7_2
  Main:    TestRecorridosAB
  ```
- ABB (insertar/borrar/recorridos) 7_3:
  ```
  Paquete: capituloSiete.ejemplos.ej7_3
  Main:    TestABB
  ```
- Verificación AVL 7_4 (cálculo de factores):
  ```
  Paquete: capituloSiete.ejemplos.ej7_4
  Main:    TestAVL
  ```
- ABB interactivo 7_5 (consola):
  ```
  Paquete: capituloSiete.ejemplos.ej7_5
  Main:    TestArbolBinario
  ```
- GUIAB 7_6 (Swing + archivo en C:\\Prueba):
  ```
  Paquete: capituloSiete.ejemplos.ej7_6
  Main:    GUIAB
  ```

### Capítulo 8 (Grafos)
- Grafo desde matriz + Dijkstra (consola):
  ```
  Paquete: capituloOcho.ejemplos.ej8_1
  Main:    TestGrafo8_1
  ```
- Grafos con listas enlazadas y consultas (consola):
  ```
  Paquete: capituloOcho.ejemplos.ej8_2
  Main:    TestGrafos
  ```

## Compilación/ejecución rápida (ejemplo real)
- Compilar y ejecutar `GUIAB` (7_6):
  ```powershell
  New-Item -ItemType Directory -Path C:\Prueba -Force
  javac -d target\classes src\main\java\com\example\libroed\capituloSiete\ejemplos\ej7_6\*.java
  java -cp target\classes com.example.libroed.capituloSiete.ejemplos.ej7_6.GUIAB
  ```

## Notas
- Si prefieres usar Maven para ejecutar una clase `main`, puedes agregar `exec-maven-plugin` o `maven-shade-plugin`. Actualmente los ejemplos se ejecutan con `javac/java` directos para simplicidad.
- `borrarelemento(int j)`
- `insertarelemento(int j, int e)`
- `imprimirlista()`

### Ejecutar el programa interactivo
Puedes ejecutarlo con Maven especificando la clase principal:
```bash
mvn -q -DskipTests -Dexec.mainClass=com.example.libroed.ejemplos.ej1_4.TestListaContigua exec:java
```

## Ejemplo 1.5: Uso de un puntero (referencias) en Java

Se implementa un ejemplo simple con una clase `Nodo` y un programa `TestPuntero` que muestra cómo dos referencias pueden apuntar al mismo objeto y reflejar los cambios.

- `src/main/java/com/example/libroed/ejemplos/ej1_5/Nodo.java`
- `src/main/java/com/example/libroed/ejemplos/ej1_5/TestPuntero.java`

Ejecutar con Maven:
```bash
mvn -q -DskipTests -Dexec.mainClass=com.example.libroed.ejemplos.ej1_5.TestPuntero exec:java