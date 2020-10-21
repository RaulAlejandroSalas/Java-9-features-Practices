# Patrones Funcionales en Java

Los patrones de disenno son una solucion que normalmente se aplica a la solucion de problemas comunes siguiendo algunas practicas o guias.
El objetivo principal es mejorar la mantenibilidad y la lectura del codigo. Existen multiples patrones de disenno que normalmente se divide en diferentes grupos:

## Patrones de Comportamiento
Estos patrones identifican comportamientos de comunicacion comunes. Como patrones populares en este grupo se pueden citar `strategy`, `visitor`, `chain of responsability`, `the template method`, `observer`, `iterator`, etc.

## Patrones Creacionales
Envuelve diferentes caminos para construir objetos. Los mas populares 
patrones son  `factory`, `builder`, `prototype`, `the factory method`,etc.

## Patrones Estructurales
Estos patrones identifican caminos para componer objetos y hacer mejoras sobre estos. Los mas populares `adapter`, `bridge`,`proxy`, `decorator`,etc.

### Factory Method Pattern
El patron factory method provee una interfaz a el cliente para crear una instancia de un objeto. Antes de la introduccion de la programacion funcional en Java este patron era implementado empleando condicionales `if`. Una buena implementacion es usando `enum`   
