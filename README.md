# Taller 2 POO 2026

## Integrantes
- Jorge Andrés Saavedra Sánchez | Rut: 22.347.590-6 | Usuario GitHub: PanchoGamer

## Descripcion del Proyecto
Se nos pide crear una simulacion de pokemon utilizando los txts que se nos han entregado, tenemos que incluir las siguientes cosas en la simulacion:

1. Menu inicial
   - Continuar
   - Nueva Partida
   - Salir
2. Menu de juego
   - Revisar Equipo
   - Salir a capturar
   - Acceso al PC
   - Retar un gimnacio
   - Desafio al Alto Mando
   - Curar Pokemon
   - Guardar
   - Guardar y salir

Cada una de las funciones tiene sus propias condiciones que limitan la creacion del simulador, tales como:
- No se puede retar un gimnacio sin antes haber derrotado al anterios (excepto el primero).
- No se puede tener mas de 1 Pokemon repetido.
- Para entrar a desafiar al Alto Mando se debe haber derrotado con anterioridad los 8 gimnacios.
- No se puede volver a capturar un pokemon ya antes capturado.
- Solo hay un turno entre batalla pokemon a pokemon. Entre esos se puede hacer los cambios que uno quiera.
- Al momento de guardar todo debe quedar guardado en el txt "Registros.txt".
- Etc.

Se nos permite el uso de ciertas librerias tales como:

```
- Scanner
- Linked List o ArrayList
- Random
- BufferedWriter
```

## Estructura del Proyecto

### Paquetes
Unicamente se tiene el paquete de "Logica", el cual mantiene todos las clases necesarias.

### Clases
- App: Maneja e inicia el proyecto, ademas de poseer todo (Listas, valores, metodos, etc), accede a los metodos necesarios para avanzar en el simulador.
- Pokemon: Nos indica todo lo util y necesario que tiene un Pokemon para asi poder instanciar las veces que sean necesarias.
- Gimnacios: Nos permite instanciar los 8 gimnacios que estan ahi basandose en el txts que se nos fue dado.
- Tabla Tipos: La tabla cual se nos fue entregada para poder realizar calculos de efectividad para los combates.
- Alto Mando: Nos muestra los Altos Mandos a enfrentar basandose en sus txt para poder instanciarlos y ser guardados para usarlos cuando sea necesario.

## Instrucciones de Ejecucion
Para poder iniciar el simulador desde cero recomiendo de primera mano el borrar todo lo que se encuentre en el txt de "Registros.txt" el cual se encuentra dentro del proyecto en la carpeta "txts"
Inicie una nueva partida desde 0 y empiece a experimentar con las opciones.

