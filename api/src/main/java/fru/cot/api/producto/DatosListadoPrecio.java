/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Record.java to edit this template
 */
package fru.cot.api.producto;

import fru.cot.api.proveedor.Proveedor;

/**
 *
 * @author Alejandro Rueda
 */
public record DatosListadoPrecio(String nombre_vendedor, Long precio_fruta) {
    public DatosListadoPrecio(Producto producto, Proveedor proveedor) {
         this(
            proveedor.getNombre_vendedor(),
            producto.getPrecio_fruta()
    );   
    }

}
