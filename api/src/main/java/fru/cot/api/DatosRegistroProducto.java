/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Record.java to edit this template
 */
package fru.cot.api;

import fru.cot.api.producto.ProductoId;
import jakarta.validation.constraints.NotBlank;

/**
 *
 * @author Alejandro Rueda
 */

public record DatosRegistroProducto(Long proveedor_id, String nombre_fruta, Long precio_fruta) {

}
