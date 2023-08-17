/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fru.cot.api.cotizacion;

import fru.cot.api.proveedores.Proveedores;

/**
 *
 * @author Alejandro Rueda
 */
public class DtoCotizacion {
    
    private String nombre;
    private long precio;
    
    public DtoCotizacion(Proveedores proveedores, long precio) {
        this.nombre = proveedores.getNombre();
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public long getPrecio() {
        return precio;
    }

    public void setPrecio(long precio) {
        this.precio = precio;
    }
    
    
}
