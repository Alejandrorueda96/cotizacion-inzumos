/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fru.cot.api.inzumos;

import fru.cot.api.cotizacion.Cotizacion;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.HashSet;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 *
 * @author Alejandro Rueda
 */
@Table(name="inzumos")
@Entity(name="Inzumos")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Inzumos {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    private String nombre;
    
    @OneToMany(mappedBy = "inzumos", cascade = CascadeType.ALL)
    private Set<Cotizacion> cotizacion = new HashSet<>();
}
