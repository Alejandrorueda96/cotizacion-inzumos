/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fru.cot.api.controller;

import fru.cot.api.cotizacion.Cotizacion;
import fru.cot.api.cotizacion.CotizacionDto;
import fru.cot.api.cotizacion.CotizacionDtos;
import fru.cot.api.cotizacion.CotizacionRepository;
import fru.cot.api.cotizacion.DtoCotizaciones;
import fru.cot.api.producto.DatosListadoProducto;
import fru.cot.api.producto.ProductoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Alejandro Rueda
 */
@RestController
@RequestMapping("/cotizacion")
public class CotizacionController {
    
    @Autowired
    private CotizacionRepository cotizacionRepository;
    
    @GetMapping
    public @ResponseBody List<CotizacionDtos> listadoProductos() {
        return cotizacionRepository.mostrarCotizaciones();
    }
    
    @GetMapping(value="/test")
    public @ResponseBody List<DtoCotizaciones> listadoPrecioNombre() {
        return cotizacionRepository.mostrarCotizacion();
    }
    
    @GetMapping(value="/hola/{nombrepro}")
    public @ResponseBody List<DtoCotizaciones> listadosPrecioNombre(@PathVariable String nombrepro) {
        return cotizacionRepository.mostrarCotizacionPrecio(nombrepro);
    }
    
    @GetMapping(value="/{id}")
    public ResponseEntity<List<Cotizacion>> getCotizacionsById(@PathVariable Long id){
        return new ResponseEntity<List<Cotizacion>>(cotizacionRepository.findCotizacionsById(id),HttpStatus.OK);        
    }

}
