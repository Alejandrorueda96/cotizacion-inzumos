package fru.cot.api.proveedor;

/**
 *
 * @author Alejandro Rueda
 */
public record DatosListadoProveedor(Long id, String nombre_vendedor) {

    public DatosListadoProveedor(Proveedor proveedor) {
        this(proveedor.getProveedorId(), proveedor.getNombre_vendedor());
    }
    
}
