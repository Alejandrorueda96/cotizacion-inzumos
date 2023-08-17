/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Record.java to edit this template
 */
package fru.cot.api.proveedor;

import jakarta.validation.constraints.NotNull;

/**
 *
 * @author Alejandro Rueda
 */
public record DatosActualizarProveedor(@NotNull Long id, String nombre_vendedor) {

}
