/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fru.cot.api.producto;

/**
 *
 * @author Alejandro Rueda
 */
public class NombrePrecio {
    private String nombre_vendedor;
    private Long precio_fruta;

    public NombrePrecio(String nombre_vendedor, Long precio_fruta) {
        this.nombre_vendedor = nombre_vendedor;
        this.precio_fruta = precio_fruta;
    }

    public String getNombre_vendedor() {
        return nombre_vendedor;
    }

    public void setNombre_vendedor(String nombre_vendedor) {
        this.nombre_vendedor = nombre_vendedor;
    }

    public Long getPrecio_fruta() {
        return precio_fruta;
    }

    public void setPrecio_fruta(Long precio_fruta) {
        this.precio_fruta = precio_fruta;
    }
    
    
}
