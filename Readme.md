# Proyecto PSP: Comunicación entre procesos en Java

Este repositorio contiene tres clases Java (`LS`, `Grep` y `Lanzador`) que demuestran cómo ejecutar procesos Java independientes y comunicarse entre ellos mediante flujos de entrada y salida. El ejemplo simula el comportamiento de `ls | grep a`, pero implementado completamente en Java.

## Descripción de las clases

### LS.java

- Ejecuta el comando `ls` sobre el directorio home del usuario (`System.getProperty("user.home")`).
- Imprime por `System.out` cada línea del resultado.
- Actúa como productor de datos para el proceso `Grep`.

### Grep.java

- Lee líneas desde `System.in`.
- Filtra aquellas que contienen la letra `"a"` (minúscula).
- Imprime las coincidencias por `System.out`.

### Lanzador.java

- Lanza `LS` y `Grep` como procesos independientes.
- Conecta la salida de `LS` con la entrada de `Grep`.
- Muestra directamente la salida filtrada, sin prefijos ni trazas.
- Espera a que ambos procesos finalicen correctamente.

## Requisitos

- Java 17 o superior instalado en el sistema.
- Sistema operativo compatible con el comando `ls` (Linux, macOS o Windows con entorno POSIX).
- Proyecto estructurado como Maven, con clases en `src/main/java/es/etg/psp/mangel/`.

## Compilación y ejecución

Desde la raíz del proyecto:

```bash
# Compilar todas las clases
javac -d target/classes src/main/java/es/etg/psp/mangel/*.java

# Ejecutar el lanzador
java -cp target/classes es.etg.psp.mangel.Lanzador
```

- Basado en los codigos del los apuntes de aula virtual
- [Repositorio lsgrep en GitHub](https://github.com/MiguelPrieto98/lsgrep)
