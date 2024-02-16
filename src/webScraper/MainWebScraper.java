package webScraper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainWebScraper {
    public static void main(String[] args) throws IOException {
/*
        String links = "https://www.bbc.com/";
        String result = getWebContent(link);
        System.out.println(result);
*/
        List<String> links = new ArrayList<>();
        links.add("https://www.bbc.com");

        links.stream().parallel().forEach(link -> System.out.println(getWebContent(link)));

    }

    private static String getWebContent(String link) {
        try {
            URL url = new URL(link);
            //openconnection devuelve un objeto diferente por eso hay que parsearlo
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            String encoding = conn.getContentEncoding();

            //descargar la pagina web
            InputStream input = conn.getInputStream();

           /* // descargar el contenido en una variable string
            String result = new BufferedReader(new InputStreamReader(input))
                    .lines().collect(Collectors.joining());  //esta creando un array de tipo stream que almacena streanms
            return result;
*/

            Stream<String> lines = new BufferedReader(new InputStreamReader(input)).lines();
            String result = lines.collect(Collectors.joining());
            return result;

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return " ";
    }
}
