/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app;

/**
 *
 * @author Alejandro Rueda
 */
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import fru.cot.api.cotizacion.Cotizacion;
import fru.cot.api.cotizacion.DtoCotizacion;
import fru.cot.api.producto.DatosListadoProducto;
import fru.cot.api.producto.Producto;
import fru.cot.api.proveedor.Proveedor;
import fru.cot.http.HttpResponse;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

public class HttpJTable {
    private JTable table;

    public void populateTableWithData(JTable table, String jsonResponse) {
        MyTableModel tableModel = new MyTableModel();
        table.setModel(tableModel);

        JsonArray jsonArray = JsonParser.parseString(jsonResponse).getAsJsonArray();
        Gson gson = new Gson();

        for (JsonElement element : jsonArray) {
            //Producto userDTO = gson.fromJson(element, Producto.class);
            DtoCotizacion cotizacionDto = gson.fromJson(element, DtoCotizacion.class);
            //DatosListadoProducto datos = gson.fromJson(element, DatosListadoProducto.class);
            //tableModel.addRow(new Object[] {  datos, datos.nombre_fruta(), datos.precio_fruta() });
            tableModel.addRow(new Object [] {cotizacionDto.getNombre(), cotizacionDto.getPrecio()});
//tableModel.addRow(new Object[] {  userDTO.getProveedor_id(), userDTO.getNombre_fruta(), userDTO.getPrecio_fruta() });
            
        }
    }

    
    class MyTableModel extends AbstractTableModel {
        private final String[] columnNames = { "Proveedor", "Precio"};
        private Object[][] data = new Object[0][2];

        public void addRow(Object[] rowData) {
            int rowCount = getRowCount();
            int columnCount = getColumnCount();

            Object[][] newData = new Object[rowCount + 1][columnCount];
            System.arraycopy(data, 0, newData, 0, rowCount);
            newData[rowCount] = rowData;

            data = newData;

            fireTableDataChanged();
        }

        @Override
        public int getRowCount() {
            return data.length;
        }

        @Override
        public int getColumnCount() {
            return columnNames.length;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            return data[rowIndex][columnIndex];
        }

        @Override
        public String getColumnName(int column) {
            return columnNames[column];
        }
    }

    public void llenarTabla(JTable tablaProveedor) {
        // Existing JTable instance
        JTable existingTable = new JTable();
        Gson gson = new Gson();
        // Simulating a JSON response
        //String jsonResponse = "[{ \"id\": \"1\", \"name\": \"John\" }, { \"id\": \"2\", \"name\": \"Jane\" }]";

        //JsonToJTableExample example = new JsonToJTableExample();
        //example.populateTableWithData(existingTable, jsonResponse);
        
        
        try {
            String url = "http://localhost:8080/cotizacion/hola/mora";
            HttpResponse httpResponse = new HttpResponse();
            httpResponse.setJsonResponse(HttpResponse.performHttpGetRequest(url));
            String respuestaJson =  httpResponse.getJsonResponse();
            System.out.println(respuestaJson);
            populateTableWithData(tablaProveedor, respuestaJson);
        } catch (IOException ex) {
            Logger.getLogger(HttpJTable.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

}

