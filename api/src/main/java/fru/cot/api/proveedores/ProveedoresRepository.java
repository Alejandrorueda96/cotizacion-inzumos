/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package fru.cot.api.proveedores;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Alejandro Rueda
 */
public interface ProveedoresRepository extends JpaRepository<Proveedores, Long>{

    
    List<Proveedores> findByNombreContaining(String nombre);
}
