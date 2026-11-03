# Reserva Salvaje

Proyecto Integrador - Videojuego con persistencia en MySQL (Java, JDBC, DAO).

Juego de gestión: el jugador administra una reserva de rescate de animales con un presupuesto
limitado. Rescata animales, los aloja en el hábitat correcto, los alimenta y los cura.

## Estado actual: ENTREGA DE AVANCE

Implementado:

- Jerarquía del modelo: `Animal` (abstracta) + `Carnivoro`, `Herbivoro`, `Ave`, `Reptil`, `AnimalAcuatico`.
- Interfaz `Cuidable`, implementada por `Animal` (y por lo tanto por todas las subclases).
- Conexión a MySQL (`ConexionDB`) y script de tablas (`sql/schema.sql`).
- `AnimalDAO` con alta, lectura, modificación y baja; `ReservaDAO` con lectura y actualización del presupuesto.
- `Main` provisorio que instancia, guarda y recupera animales de la base.

Pendiente para la entrega final: `ReservaService` con las reglas de negocio, las excepciones
personalizadas del juego y el `Main` completo con los errores forzados.

## Requisitos

- Java 17 o superior (JDK)
- MySQL 8.0 o superior
- Maven 3.8 o superior (o un IDE que lo traiga: IntelliJ, Eclipse, NetBeans)

## Cómo ejecutarlo

1. Ejecutar el script `sql/schema.sql` en MySQL (Workbench o consola: `mysql -u root -p < sql/schema.sql`).
2. Revisar usuario y contraseña de MySQL en `src/main/java/dao/ConexionDB.java`
   (o definir las variables de entorno `DB_USER` y `DB_PASSWORD`).
3. Compilar y ejecutar:

       mvn compile exec:java

   o abrir el proyecto en el IDE y ejecutar la clase `main.Main`.

Para empezar de cero antes de una demo: `TRUNCATE TABLE animal;` en la base `reserva_salvaje`.

## Estructura

    sql/schema.sql                 tablas animal (tabla unica con columna tipo) y reserva
    src/main/java/model/           Animal y subclases, Cuidable, TipoHabitat, TipoAnimal, Reserva
    src/main/java/dao/             ConexionDB, AnimalDAO, ReservaDAO
    src/main/java/exception/       ReservaException (base) y PersistenciaException
    src/main/java/main/Main.java   Main provisorio del avance

## Cambios respecto al guion

- Se agregó el enum `TipoAnimal`: es el valor que se guarda en la columna `tipo`, y evita escribir
  textos sueltos ("CARNIVORO", etc.) repetidos por el código.
- Se agregó la excepción base `ReservaException`: todas las excepciones del juego van a heredar de
  ella, así el `Main` puede capturar cualquiera de forma controlada.
- `schema.sql` usa `CREATE TABLE IF NOT EXISTS` para poder ejecutarse más de una vez sin errores.
