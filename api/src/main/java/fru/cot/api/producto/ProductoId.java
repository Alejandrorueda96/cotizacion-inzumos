/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fru.cot.api.producto;

import jakarta.persistence.Embeddable;
import java.io.Serializable;

/**
 *
 * @author Alejandro Rueda
 */

public class ProductoId implements Serializable{
    private Long proveedorId;
    private String nombre_fruta;
    public Long getProveedor_id() {
        return proveedorId;
    }

    public void setProveedor_id(Long proveedor_id) {
        this.proveedorId = proveedor_id;
    }

    public String getNombre_fruta() {
        return nombre_fruta;
    }

    public void setNombre_fruta(String nombre_fruta) {
        this.nombre_fruta = nombre_fruta;
    }
    
}
