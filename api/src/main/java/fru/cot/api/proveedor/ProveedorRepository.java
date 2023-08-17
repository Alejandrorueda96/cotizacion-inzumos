/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package fru.cot.api.proveedor;
import fru.cot.api.DatosRegistroProveedor;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 *
 * @author Alejandro Rueda
 */
public interface ProveedorRepository extends JpaRepository<Proveedor, Long> {

    List<Proveedor> findProveedorsByProveedorId (Long productoId);
    
    
}
