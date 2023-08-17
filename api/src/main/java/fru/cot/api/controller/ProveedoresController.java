/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fru.cot.api.controller;

import fru.cot.api.proveedor.ProveedorRepository;
import fru.cot.api.proveedores.Proveedores;
import fru.cot.api.proveedores.ProveedoresRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Alejandro Rueda
 */
@RestController
@RequestMapping("/proveedor")
public class ProveedoresController {
    @Autowired
    private ProveedoresRepository proveedoresRepository;
    
      @GetMapping("/tutorials")
  public ResponseEntity<List<Proveedores>> getAllTutorials(@RequestParam(required = false) String nombre) {
    List<Proveedores> tutorials = new ArrayList<Proveedores>();

    if (nombre == null)
      proveedoresRepository.findAll().forEach(tutorials::add);
    else
      proveedoresRepository.findByNombreContaining(nombre).forEach(tutorials::add);

    if (tutorials.isEmpty()) {
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    return new ResponseEntity<>(tutorials, HttpStatus.OK);
  }
}
