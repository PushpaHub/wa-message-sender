import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LeerDatos {

    private String fotoRuta;
    private String excelRuta;
    private List<String> saludos;
    private String mensajeBody;
    private List<String> despedidas;

    // Constructor que acepta la ruta del archivo
    public LeerDatos(String archivo) {
        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            String line;

            // Lee la ruta de la foto, ignorando comentarios y líneas vacías
            line = reader.readLine();
            while (line != null && (line.trim().isEmpty() || line.trim().startsWith("#"))) {
                line = reader.readLine();
            }
            if (line != null && !line.trim().isEmpty() && !line.trim().startsWith("#")) {
                fotoRuta = line.trim();
                System.out.println("Foto " + fotoRuta);
            }

            // Lee la ruta del archivo Excel, ignorando comentarios y líneas vacías
            line = reader.readLine();
            while (line != null && (line.trim().isEmpty() || line.trim().startsWith("#"))) {
                line = reader.readLine();
            }
            if (line != null && !line.trim().isEmpty() && !line.trim().startsWith("#")) {
                excelRuta = line.trim();
                System.out.println("Excel " + excelRuta);
            }

            // Lee las opciones de saludo, ignorando comentarios y líneas vacías
            line = reader.readLine();
            saludos = new ArrayList<>();
            while (line != null && (line.trim().isEmpty() || line.trim().startsWith("#"))) {
                line = reader.readLine();
            }
            while (line != null && !line.trim().isEmpty() && !line.trim().startsWith("#")) {
                saludos.add(line.trim());
                line = reader.readLine();
            }
            System.out.println("saludos " + saludos);

            // Lee el cuerpo del mensaje, ignorando comentarios
            mensajeBody = "";
            line = reader.readLine();
            while (line != null && (line.trim().isEmpty() || line.trim().startsWith("#"))) {
                line = reader.readLine();
            }
            while (line != null && !line.trim().startsWith("#")) {
                if (!mensajeBody.isEmpty()) {
                    mensajeBody += "\n"; // Agrega salto de línea solo si la línea no está vacía
                }
                mensajeBody += line.trim(); // Agrega la línea, incluso si está vacía
                line = reader.readLine();
            }
            // Si la última línea es vacía, elimina el salto de línea extra
            if (mensajeBody.endsWith("\n")) {
                mensajeBody = mensajeBody.substring(0, mensajeBody.length() - 1); // Elimina el salto de línea extra al final
            }
            System.out.println("mensajeBody " + mensajeBody);

            // Lee las opciones de despedida
            line = reader.readLine();
            despedidas = new ArrayList<>();
            while (line != null && (line.trim().isEmpty() || line.trim().startsWith("#"))) {
                line = reader.readLine();
            }
            while (line != null && !line.trim().isEmpty() && !line.trim().startsWith("#")) {
                despedidas.add(line.trim());
                line = reader.readLine();
            }
            System.out.println("despedidas " + despedidas);

        } catch (IOException e) {
            e.printStackTrace();
            // Maneja la excepción según sea necesario
        }
    }

    // Métodos getter para acceder a los datos cargados
    public String getFotoRuta() {
        return fotoRuta;
    }

    public String getExcelRuta() {
        return excelRuta;
    }

    public List<String> getSaludos() {
        return saludos;
    }

    public String getMensajeBody() {
        return mensajeBody;
    }

    public List<String> getDespedidas() {
        return despedidas;
    }
}
