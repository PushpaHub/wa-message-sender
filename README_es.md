# WhatsApp Message Sender
[Read in English](README_en.md)

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

## **Consideraciones**
- **Privacidad y Ética:** Asegúrate de tener consentimiento para enviar mensajes automatizados.
- **Evita Bloqueos:** Implementa intervalos aleatorios entre mensajes para evitar restricciones de WhatsApp.
- **Resolución de Errores:**
  - Asegúrate de que las rutas en el archivo `datos.txt` sean correctas.
  - Verifica que el archivo Excel tenga el formato adecuado.
  - Si no se carga el perfil de Chrome, revisa la ruta de `user-data-dir`.

---

## **Posibles Mejoras Futuras**
- Soporte para múltiples navegadores (Firefox, Edge).
- Interfaz gráfica para simplificar la configuración.
- Gestión de errores más robusta y registros detallados.

---

## **Contacto**
Para dudas o sugerencias, puedes escribir a [tu_email@example.com].
