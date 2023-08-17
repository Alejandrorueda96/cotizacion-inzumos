/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fru.cot.api.controller;

import fru.cot.api.DatosRegistroProducto;
import fru.cot.api.producto.DatosListadoPrecio;
import fru.cot.api.producto.DatosListadoProducto;
import fru.cot.api.producto.NombrePrecio;
import fru.cot.api.producto.Producto;
import fru.cot.api.producto.ProductoRepository;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Alejandro Rueda
 */
@RestController
@RequestMapping("/productos")
public class ProductoController {
    
    @Autowired
    private ProductoRepository productoRepository;
    
    @PostMapping
    public void registrarProducto(@RequestBody DatosRegistroProducto datosRegistroProducto){
        productoRepository.save(new Producto(datosRegistroProducto));
    }
    
    @GetMapping
    public List<DatosListadoProducto> listadoProductos() {
        return productoRepository.findAll().stream().map(DatosListadoProducto::new).toList();
    }
    /*
    @GetMapping(value="/{proveedor_id}")
    public List<Producto> idProducto (@PathVariable Long proveedor_id){
        return productoRepository.productoid(proveedor_id);
    }
*/
    @GetMapping(value="/nombre")
    public @ResponseBody List<String> nombresProducto(){
        return productoRepository.nombreProduct();
        
    }
    
    /*
    @GetMapping(value="/{precio_fruta}")
    public List<NombrePrecio> provPrecio(@PathVariable Long precio_fruta){       
        //return productoRepository.proveedorPrecio(precio_fruta);
        return productoRepository.proveedorPrecio(precio_fruta);
    }
*/
}
