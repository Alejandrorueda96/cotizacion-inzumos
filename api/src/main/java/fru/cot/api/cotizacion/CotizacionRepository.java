/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package fru.cot.api.cotizacion;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Alejandro Rueda
 */
public interface CotizacionRepository extends JpaRepository<Cotizacion, Long>{
    
    List<Cotizacion> findCotizacionsById(Long cotizacionId);
    
    @Query(value="select proveedorId, inzumId, precio from cotizacion",nativeQuery = true)
    List<CotizacionDtos> mostrarCotizaciones();
    
    @Query(value="select proveedores.nombre, cotizacion.precio"
             +" from cotizacion"
             +" inner join inzumos on inzumos.id = cotizacion.inzumId"
             +" inner join proveedores on proveedores.id = cotizacion.proveedorId where inzumos.nombre = \"mora\""
            ,nativeQuery = true)
    List<DtoCotizaciones> mostrarCotizacion();
    
    @Query(value="select proveedores.nombre, cotizacion.precio"
             +" from cotizacion"
             +" inner join inzumos on inzumos.id = cotizacion.inzumId"
             +" inner join proveedores on proveedores.id = cotizacion.proveedorId where inzumos.nombre=:nombrepro"
            ,nativeQuery = true)
    List<DtoCotizaciones> mostrarCotizacionPrecio(@Param("nombrepro")String nombre);
    
}
