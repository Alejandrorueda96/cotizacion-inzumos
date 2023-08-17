/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package fru.cot.api.producto;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import fru.cot.api.producto.Producto;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Alejandro Rueda
 */
public interface ProductoRepository extends JpaRepository<Producto, ProductoId>{
    /*
    @Query(value="select * from fruta where proveedor_id=:proveedor_id", nativeQuery = true)
    public List<Producto> productoid(@Param("proveedor_id") Long proveedor_id);
    */
    List<Producto> findProductosByProveedorId(Long proveedor_id); 
       
    
    @Query(value = "SELECT DISTINCT nombre_fruta FROM fruta", nativeQuery = true)
    List<String> nombreProduct();
    /*
    @Query(value = "select nombre_vendedor, precio_fruta from proveedor join fruta on proveedor.proveedor_id = fruta.proveedor_id and precio_fruta=:precio_fruta", nativeQuery = true)
    List<NombrePrecio> proveedorPrecio(@Param("precio_fruta") Long precio_fruta);
    */
}
    
