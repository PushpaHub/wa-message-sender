# WhatsApp Message Sender
[Read in English](README_en.md)

<img src="Banner.jpg" alt="Banner" style="width: 100%;">


---

## **Descripción del Proyecto**
**WhatsAppMessageSender** es una aplicación desarrollada en **Java** que automatiza el envío de mensajes personalizados a través de **WhatsApp Web**. Utiliza **Selenium WebDriver** para interactuar con la interfaz web de WhatsApp y permite el envío de mensajes y archivos multimedia (fotos/videos) a una lista de contactos especificada en un archivo Excel.

### **Características Principales**
- Personalización de mensajes con saludos y despedidas aleatorios.
- Lectura de contactos desde un archivo Excel.
- Posibilidad de enviar mensajes multimedia (fotos/videos).
- Integración con perfiles persistentes del navegador para mantener la sesión activa.

---

## **Requisitos Previos**
1. **Java Development Kit (JDK):** Versión 8 o superior.
2. **Maven:** Para gestionar dependencias.
3. **ChromeDriver:** Compatible con la versión de Google Chrome instalada.
4. **Google Chrome:** Instalado en el sistema.
5. **Selenium WebDriver:** Dependencia manejada a través de Maven.
6. **AutoIt:** Para manejar la carga de archivos multimedia.

---

## **Estructura del Proyecto**
- **`WhatsAppMessageSender.java:`** Clase principal que gestiona el flujo del programa.
- **`Contact.java:`** Representa un contacto con atributos de número, nombre y nombre completo.
- **`LeerDatos.java:`** Lee configuraciones (rutas de archivos, saludos, mensajes) desde un archivo TXT.
- **`EscribeMensaje.java:`** Genera mensajes personalizados.
- **`uploadFile.exe:`** Script AutoIt para manejar la carga de archivos.

---

## **Archivos Externos Necesarios**
### 1. **Archivo TXT de Configuración (`datos.txt`):**
Define las rutas y configuraciones del programa.
- **Formato Ejemplo:**
  ```plaintext
  # Ruta de la foto o video a enviar
  C:/path/to/image.jpg

  # Ruta del archivo Excel con contactos
  C:/path/to/contacts.xlsx

  # Lista de saludos (uno por línea)
  Hola %NOMBRE%
  Buenas %NOMBRE%

  # Cuerpo del mensaje (puede incluir varias líneas)
  Este es un mensaje automatizado enviado desde un programa en Java.

  # Lista de despedidas (una por línea)
  Saludos cordiales
  Atentamente
  ```
### 2. **Archivo Excel con Contactos:**
Debe contener los siguientes encabezados:
- **Formato Ejemplo:**
  | Numero       | Nombre     | Nombre_completo    |
  |--------------|------------|--------------------|
  | 5211234567890 | Juan       | Juan Pérez         |
  | 5219876543210 | María      | María López Gómez  |

---

## **Cómo Usar**
1. **Configura el Ambiente:**
   - Instala JDK y Maven.
   - Descarga e instala Google Chrome.
   - Descarga el **ChromeDriver** compatible con tu versión de Chrome y colócalo en el mismo directorio del programa.

2. **Configura el Perfil de Chrome:**
   - Inicia sesión en WhatsApp Web manualmente desde Chrome.
   - Copia el directorio de datos del usuario al que apunta `user-data-dir` en el código (por defecto: `C:/chrome-user-data`).

3. **Prepara los Archivos Externos:**
   - Crea y configura el archivo `datos.txt`.
   - Prepara el archivo Excel con la lista de contactos.

4. **Compila y Ejecuta el Programa:**
   - Ejecuta el siguiente comando en el directorio del proyecto:
     ```bash
     mvn clean compile exec:java
     ```
   - Alternativamente, compila y ejecuta con:
     ```bash
     javac *.java
     java WhatsAppMessageSender
     ```

5. **Envía Mensajes:**
   - Escanea el código QR en WhatsApp Web la primera vez que corras el programa.
   - El programa enviará mensajes automáticamente basados en la configuración.

---

## Solución de problemas
- **Mensajes no entregados**:
  - Asegúrate de que los números de teléfono estén formateados correctamente, incluyendo el código de país.

- **Problemas con el navegador**:
  - Verifica que la versión de ChromeDriver coincida con la versión del navegador Chrome instalado.

- **Errores de archivos**:
  - Verifica las rutas en el archivo de texto y asegúrate de que el formato del archivo Excel sea correcto.

---

## Notas
- Mantén tu navegador Chrome actualizado.
- Usa una cuenta de WhatsApp dedicada para pruebas para evitar posibles bloqueos.
- Asegúrate de cumplir con los términos de servicio de WhatsApp al utilizar esta herramienta.