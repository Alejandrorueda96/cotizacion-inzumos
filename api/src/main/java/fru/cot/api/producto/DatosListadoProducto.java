/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Record.java to edit this template
 */
package fru.cot.api.producto;

/**
 *
 * @author Alejandro Rueda
 */
public record DatosListadoProducto(Long proveedor_id, String nombre_fruta, Long precio_fruta) {
    public DatosListadoProducto(Producto producto) {
        this(
            producto.getProveedorId(),
            producto.getNombre_fruta(),
            producto.getPrecio_fruta()
        
        );
    }

}
