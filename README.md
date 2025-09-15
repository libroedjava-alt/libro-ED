# Libro ED

Proyecto Java (Maven) base para "libro ED".

## Requisitos
- Java 17 o superior
- Maven 3.9+

## Estructura
```
libro-ed/
  ├─ pom.xml
  ├─ src/
  │  ├─ main/java/com/example/libroed/App.java
  │  ├─ main/java/com/example/libroed/ejemplos/ej11/ListaEnterosEj11.java
  │  └─ test/java/com/example/libroed/AppTest.java
  └─ README.md
```

Organización: cada ejemplo estará en su propio paquete/clase bajo `com.example.libroed.ejemplos.ejXX` para mantener separación clara.

## Comandos útiles
- Compilar y ejecutar pruebas:
  ```bash
  mvn clean test
  ```

- Ejecutar la aplicación (usa exec-maven-plugin):
  ```bash
  mvn -q -DskipTests exec:java
  ```

- Empaquetar (genera `target/libro-ed-1.0.0-SNAPSHOT.jar`):
  ```bash
  mvn clean package
  ```

> Nota: Para ejecutar el `.jar` directamente necesitarás incluir dependencias en un "fat jar" o usar `exec-maven-plugin`. Si lo deseas, puedo agregar el `maven-shade-plugin` para crear un jar ejecutable.

## Ejemplo 1.1: Consultar el elemento j-ésimo de una lista P

Este ejemplo implementa la lógica solicitada para leer el elemento j-ésimo de una lista `P`.

### Pasos del algoritmo
- Leer longitud de la lista `L`.
- Si `L = 0`, visualizar: `"Error, lista vacía"`.
- Si `0 <= j < L`, asignar `B <- P(j)` y visualizar `"valor = ", B`.
- En otro caso, visualizar: `"solicitado no existe en la Lista"`.

Nota: Aunque la descripción inicial menciona `1 <= j <= L`, el pseudocódigo y el código Java original trabajan con índices base 0 (`0 <= j < L`), que es lo natural en Java. Se respeta exactamente esta lógica.

### Pseudocódigo
```
Inicio
  Leer L
  si L = 0
    Entonces escribir "Error lista vacía"
  sino
    si 0 <= j < L
      Entonces B <- P(j)
               escribir "valor = ", B
    sino
      escribir "Elemento solicitado no existe en la Lista"
    fin_si
  fin_si
fin
```

### Código Java utilizado

Archivo: `src/main/java/com/example/libroed/ejemplos/ej11/ListaEnterosEj11.java`
```java
public void consultarelemento(int j) {
    int B;
    if (L == 0) {
        System.out.println("Error, lista vacía");
    } else if ((j >= 0) && (j < L)) {
        B = P[j];
        System.out.println("valor = " + B);
    } else {
        System.out.println("solicitado no existe en la Lista");
    }
}
```

### Prueba de escritorio
Supongamos `P = [10, 20, 30]` y `L = 3`.

- Caso 1: `j = 1`
  - `0 <= 1 < 3` es verdadero
  - `B <- P[1] = 20`
  - Salida: `valor = 20`

- Caso 2: `L = 0` (lista vacía)
  - Salida: `Error, lista vacía`

- Caso 3: `j = 5`
  - `0 <= 5 < 3` es falso
  - Salida: `solicitado no existe en la Lista`

### Ejecución de ejemplo en `App.java`
En `main`, se crea una lista `P = {10, 20, 30}` usando `ListaEnterosEj11` y se consulta `j = 1`, por lo que verás:
```
Hola, Libro ED!
valor = 20
```
