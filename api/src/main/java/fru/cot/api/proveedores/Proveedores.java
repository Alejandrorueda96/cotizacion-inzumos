/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fru.cot.api.proveedores;

import fru.cot.api.cotizacion.Cotizacion;
import fru.cot.api.inzumos.Inzumos;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author Alejandro Rueda
 */

@Table(name="proveedores")
@Entity(name="Proveedores")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Proveedores {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nombre;

    @OneToMany(mappedBy = "proveedores", cascade = CascadeType.ALL)
    private Set<Cotizacion> cotizacion;
    
    
}
