/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fru.cot.api.cotizacion;

import fru.cot.api.inzumos.Inzumos;
import fru.cot.api.proveedores.Proveedores;

/**
 *
 * @author Alejandro Rueda
 */
public class CotizacionDto {
    
    private long proveedorId;
    private long inzumoId;
    private long precio;

    public long getProveedorId() {
        return proveedorId;
    }

    public void setProveedorId(long proveedorId) {
        this.proveedorId = proveedorId;
    }

    public long getInzumoId() {
        return inzumoId;
    }

    public void setInzumoId(long inzumoId) {
        this.inzumoId = inzumoId;
    }

    public long getPrecio() {
        return precio;
    }

    public void setPrecio(long precio) {
        this.precio = precio;
    }
    
    public CotizacionDto(Proveedores proveedores, Inzumos inzumos, long precio){
        this.proveedorId = proveedores.getId();
        this.inzumoId = inzumos.getId();
        this.precio = precio;
    }
    
}
