/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import fru.cot.http.HttpResponse;
import java.io.IOException;
import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;

/**
 *
 * @author Alejandro Rueda
 */
public class HttpComboBox {
    
    
        public void llenarComboBox (JComboBox comboBoxProveedor){
     
            try {
            //String url ="http://localhost:8080/proveedores";
            String url ="http://localhost:8080/productos/nombre";
            HttpResponse httpResponse = new HttpResponse();
            httpResponse.setJsonResponse(HttpResponse.performHttpGetRequest(url));
            String respuestaJson = httpResponse.getJsonResponse();
            
                System.out.println(respuestaJson);
            
            JsonElement jsonElement = JsonParser.parseString(respuestaJson);
            JsonArray jsonArray = jsonElement.getAsJsonArray();
            for(int i=0; i<jsonArray.size(); i++)
            {
                jsonArray.get(i);
                System.out.println(jsonArray.get(i).getAsString());
                comboBoxProveedor.addItem(jsonArray.get(i).getAsString());
            }
            /*
            for (JsonElement element : jsonArray) {
                //String proveedorName = element.getAsJsonObject().get("nombre_vendedor").getAsString();
                
                comboBoxProveedor.addItem(proveedorName);          
            }            
            */
            
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        
    }
    
    
}
