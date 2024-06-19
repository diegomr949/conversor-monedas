# Conversor de Monedas

Este proyecto de Java implementa un Conversor de Monedas que utiliza una API de tasas de cambio para realizar conversiones entre varias monedas. A continuación, se detallan los pasos para configurar, compilar y ejecutar el proyecto.

## Contenido

1. [Requisitos](#requisitos)
2. [Configuración](#configuración)
3. [Ejecución](#ejecución)
4. [Uso](#uso)
5. [Créditos](#créditos)

## Requisitos

- Java Development Kit (JDK) 8 o superior instalado.
- Acceso a Internet para realizar solicitudes a la API de tasas de cambio.

## Configuración

1. **Clonación del Repositorio:**

   Clona este repositorio en tu máquina local utilizando Git:


2. **Importación del Proyecto:**

Abre IntelliJ IDEA (u otro IDE de tu elección) y selecciona "Open" para abrir el proyecto.

3. **Agregar la Biblioteca Gson:**

- Ve a `File` > `Project Structure` en IntelliJ IDEA.
- Selecciona `Libraries` en el panel izquierdo.
- Haz clic en el signo `+` y elige `From Maven...`.
- Busca "gson" y selecciona la versión adecuada.
- Haz clic en `OK` para agregar la biblioteca Gson al proyecto.

4. **Configuración de la API Key:**

- Obtén una clave de API de la [Exchange Rate API](https://www.exchangerate-api.com/).
- Crea un archivo `config.properties` en la raíz del proyecto con el siguiente contenido:

  ```
  api.key = tu_clave_de_api_aqui
  ```

## Ejecución

- Ejecuta la clase `Main.java` para iniciar la aplicación.

## Uso

1. **Interfaz de Usuario:**

- La aplicación mostrará un menú interactivo en la consola.
- Elige una opción de conversión introduciendo el número correspondiente.
- Introduce la cantidad en USD que deseas convertir a la moneda seleccionada.

2. **Resultados:**

- La aplicación mostrará el resultado de la conversión en la consola.

## Créditos

- Este proyecto fue desarrollado como parte del programa ONE.
- Autores: [Tu Nombre](https://github.com/tu-usuario)
