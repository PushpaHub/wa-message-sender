import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WhatsAppMessageSender {

    public static void main(String[] args) {
        // Configura la ruta del ChromeDriver
        String currentDirectory = System.getProperty("user.dir"); // Obtiene el directorio actual del programa
        System.setProperty("webdriver.chrome.driver", currentDirectory + File.separator + "chromedriver.exe");

        // Configura ChromeOptions para usar un perfil de usuario persistente
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=C:/chrome-user-data"); // Directorio para guardar el perfil
        options.addArguments("profile-directory=Default"); // Usa el perfil "Default"

        // Inicia el navegador con las opciones configuradas
        WebDriver driver = new ChromeDriver(options);

        try {
            // Abrir WhatsApp Web
            driver.get("https://web.whatsapp.com/");
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));

            // Esperar hasta que el usuario escanee el código QR y se cargue la página
            System.out.println("Escanea el código QR para iniciar sesión primera vez...");
            // wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div[title='Menú']"))); // Asegurarse de que se cargó correctamente
            Thread.sleep(10000);

            // Leer la configuración desde el archivo TXT
            LeerDatos datos = new LeerDatos("datos.txt");

            // Crear instancia de EscribeMensaje con los datos del archivo
            EscribeMensaje generadorMensajes = new EscribeMensaje(datos.getSaludos(), datos.getMensajeBody(), datos.getDespedidas());

            // Carga los contactos desde el archivo Excel en una lista
            List<Contact> contacts = loadContactsFromExcel(datos.getExcelRuta());

            // Itera sobre los contactos y envía mensajes
            for (Contact contact : contacts) {
                // Generar el mensaje completo para el contacto
                String mensaje = generadorMensajes.generarMensaje(contact.name);

                // Construir la URL para enviar el mensaje
                String url = "https://web.whatsapp.com/send?phone=" + contact.phoneNumber +
                        "&text=" + mensaje;

                // Navegar a la URL
                driver.get(url);
                System.out.print(contact.nombreCompleto + " (" + contact.phoneNumber + ")");

                // Esperar a que WhatsApp cargue la conversación
                Thread.sleep(10000);

                // Hacer clic en el botón "Adjuntar" (clip)
                wait = new WebDriverWait(driver, Duration.ofSeconds(30));
                WebElement attachButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[title='Adjuntar']")));
                attachButton.click();

                // Hacer clic en el botón "Fotos y Videos"
                Thread.sleep(3000); // Espera unos segundos para que se abra el menú de opciones
                WebElement photoVideoButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Fotos y videos']")));
                photoVideoButton.click();

                // Llamar al método para enviar la foto
                enviarFoto(datos.getFotoRuta());
                Thread.sleep(10000); // Espera unos segundos para que se cargue la foto

                // Busca y haz clic en el botón de enviar
                WebElement sendButton = driver.findElement(By.cssSelector("span[data-icon='send']"));
                sendButton.click();
                System.out.println(" - Enviado");
                Thread.sleep(3000); // Espera unos segundos para ver que el mensaje se envió

                // Espera un tiempo aleatorio antes de enviar el siguiente mensaje
                int randomWait = new Random().nextInt(15000) + 5000; // Entre 5 y 20 segundos
                Thread.sleep(randomWait);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // Dejar el navegador abierto para que el usuario pueda usarlo si desea
            System.out.println("Mensajes enviados. WhatsApp Web sigue abierto. Puedes cerrarlo manualmente.");
        }
    }

    /**
     * Carga los contactos desde un archivo Excel y los devuelve como una lista.
     */
    private static List<Contact> loadContactsFromExcel(String filePath) {
        List<Contact> contacts = new ArrayList<>();
        try (FileInputStream file = new FileInputStream(new File(filePath));
             Workbook workbook = new XSSFWorkbook(file)) {

            Sheet sheet = workbook.getSheetAt(0);
            for (Row row : sheet) {
                // Omite la primera fila si es un encabezado
                if (row.getRowNum() == 0) continue;

                String phoneNumber = row.getCell(0).getStringCellValue(); // Columna "Numero"
                String name = row.getCell(1).getStringCellValue(); // Columna "Nombre"
                String nombreCompleto = row.getCell(2).getStringCellValue(); // Columna "Nombre_completo"
                contacts.add(new Contact(phoneNumber, name, nombreCompleto));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return contacts;
    }


    /**
     * AutoIt envia la foto, photoPath es el parámetro
     */
    public static void enviarFoto(String photoPath) {
        try {
            String currentDirectory = System.getProperty("user.dir"); // Obtiene el directorio actual del programa
            String autoItScriptPath = currentDirectory + File.separator + "uploadFile.exe";

            Process process = new ProcessBuilder(autoItScriptPath, photoPath).start();
            process.waitFor(); // Esperar que AutoIt termine
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
