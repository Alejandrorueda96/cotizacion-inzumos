package fru.cot.http;

/**
 *
 * @author Alejandro Rueda
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpResponse {
    
    private String jsonResponse;

    public void setJsonResponse(String jsonResponse) {
        this.jsonResponse = jsonResponse;
    }

    public  String getJsonResponse() {
        return jsonResponse;
    }

 
    public static String performHttpGetRequest(String url) throws IOException {
        StringBuilder response = new StringBuilder();
        
        HttpURLConnection connection = null;
        BufferedReader reader = null;
        
        try {
            connection = (HttpURLConnection) new URL(url).openConnection();
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String line;
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
            } else {
                System.out.println("Error: " + responseCode);
            }
        } finally {
            if (reader != null) {
                reader.close();
            }
            if (connection != null) {
                connection.disconnect();
            }
        }
        
        return response.toString();
    }
    

    public static void main(String[] args) {

    }
}
