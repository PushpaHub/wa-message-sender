import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Random;

public class EscribeMensaje {

    private final List<String> saludos;
    private final String mensajeCentral;
    private final List<String> despedidas;

    // Constructor para inicializar los datos
    public EscribeMensaje(List<String> saludos, String mensajeCentral, List<String> despedidas) {
        this.saludos = saludos;
        this.mensajeCentral = mensajeCentral;
        this.despedidas = despedidas;
    }

    // Método para generar el mensaje completo
    public String generarMensaje(String contactName) {
        Random rand = new Random();

        // Seleccionar un saludo aleatorio y reemplazar %NOMBRE% con el nombre del contacto
        String saludo = saludos.get(rand.nextInt(saludos.size())).replace("%NOMBRE%", contactName);

        // Seleccionar una despedida aleatoria
        String despedida = despedidas.get(rand.nextInt(despedidas.size()));

        // Combinar las partes del mensaje
        String mensajeCompleto = saludo + "\n\n" + mensajeCentral + "\n\n" + despedida;

        // Codificar el mensaje en formato URL
        try {
            return URLEncoder.encode(mensajeCompleto, StandardCharsets.UTF_8.name());
        } catch (Exception e) {
            e.printStackTrace();
            // Retornar el mensaje sin codificar si ocurre un error
            return mensajeCompleto;
        }
    }
}
