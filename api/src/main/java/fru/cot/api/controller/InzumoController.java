/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fru.cot.api.controller;

import fru.cot.api.inzumos.Inzumos;
import fru.cot.api.inzumos.InzumosRepository;
import fru.cot.api.producto.ProductoRepository;
import fru.cot.api.proveedores.ProveedoresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Alejandro Rueda
 */
@RestController
@RequestMapping("/inzumos")
public class InzumoController {
    
    @Autowired
    private ProveedoresRepository proveedoresRepository;
    @Autowired
    private InzumosRepository inzumosRepository;
    
    

    
}
