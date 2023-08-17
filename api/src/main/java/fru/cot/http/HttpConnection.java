package fru.cot.http;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import javax.swing.DefaultComboBoxModel;
public class HttpConnection {
    
    public class User{
        private int id;
        private String name;
    }
    
    public static void main(String[] args) {
        

        
        try {
            URL url = new URL("http://localhost:8080/proveedores");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            
                        int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String line;
                StringBuilder response = new StringBuilder();
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                reader.close();

                // Process the response
                System.out.println("Response: " + response.toString());
                
                JsonElement jsonElement = JsonParser.parseString(response.toString());
                JsonArray jsonArray = jsonElement.getAsJsonArray();
                
                // TODO: Parse the JSON response and update the Swing UI accordingly
                
            } else {
                System.out.println("Error: " + responseCode);
            }

            connection.disconnect();
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
