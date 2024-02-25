package HTTPS;
import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class HttpsRequest {

    /**
     * Realiza una solicitud HTTPS y muestra la respuesta en la consola.
     * Todo se realizará
     */
    public static void main(String[] args) {
        String urlStr = "https://jsonplaceholder.typicode.com/posts/1"; // URL de ejemplo
//        String urlStr = "https://www.google.com"; // URL de ejemplo
//        String urlStr = "https://www.geeksforgeeks.org/multi-threaded-chat-application-set-1/";
        try {
            // Crear una nueva solicitud HTTPS
            URL url = new URL(urlStr);
            HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            // Leer la respuesta del servidor
            InputStream responseStream = connection.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(responseStream));
            String line;
            StringBuilder response = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            // Imprimir la respuesta
            System.out.println("Respuesta del servidor:");
            System.out.println(response.toString());

            // Cerrar la conexión
            connection.disconnect();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

