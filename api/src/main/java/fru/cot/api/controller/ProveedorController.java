package fru.cot.api.controller;

import fru.cot.api.DatosRegistroProveedor;
import fru.cot.api.proveedor.DatosActualizarProveedor;
import fru.cot.api.proveedor.DatosListadoProveedor;
import fru.cot.api.proveedor.Proveedor;
import fru.cot.api.proveedor.ProveedorRepository;
import fru.cot.api.proveedor.DatosListadoProveedor;
import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 * @author Alejandro Rueda
 */
@RestController
@RequestMapping("/proveedores")
public class ProveedorController {
    
    @Autowired
    private ProveedorRepository proveedorRepository;
    
    
    @PostMapping
    public void registrarProveedor(@RequestBody DatosRegistroProveedor datosRegistroProveedor) {
        proveedorRepository.save(new Proveedor (datosRegistroProveedor));
    }
    
    @GetMapping
    public List<DatosListadoProveedor> listadoProveedores() {
        return proveedorRepository.findAll().stream().map(DatosListadoProveedor::new).toList();
    }
    
    @GetMapping(value="/{id}")
    public ResponseEntity<Proveedor> obtenerProveedorById(@PathVariable long id) {
        Proveedor proveedor = proveedorRepository.findById(id).orElseThrow();
        return new ResponseEntity<>(proveedor, HttpStatus.OK);
        
    }
    
    
    @PutMapping
    @Transactional
    public void actualizarProveedor(@RequestBody @Valid DatosActualizarProveedor datosActualizarProveedor) {
        Proveedor proveedor = proveedorRepository.getReferenceById(datosActualizarProveedor.id());
        proveedor.actualizarDatos(datosActualizarProveedor); 
        
    
    }
    
    @DeleteMapping("/{id}")
    @Transactional
    public void eliminarProveedor(@PathVariable Long id) {
        Proveedor proveedor = proveedorRepository.getReferenceById(id);
        proveedorRepository.delete(proveedor);
    }
  
}
