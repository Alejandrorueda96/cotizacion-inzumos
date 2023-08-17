/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fru.cot.api.cotizacion;

import com.fasterxml.jackson.annotation.JsonIgnore;
import fru.cot.api.inzumos.Inzumos;
import fru.cot.api.proveedores.Proveedores;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author Alejandro Rueda
 */
@Table(name = "cotizacion")
@Entity(name="Cotiazacion")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cotizacion {
    
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
  
    
    
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JsonIgnore
    @JoinColumn(name="proveedorid")
    private Proveedores proveedores;
    
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JsonIgnore
    @JoinColumn(name = "inzumid")
    private Inzumos inzumos;
    private long precio;
    
    public Cotizacion(Proveedores proveedores, Inzumos inzumos, long precio) {
        this.proveedores = proveedores;
        this.inzumos = inzumos;
        this.precio = precio;
    }
    
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cotizacion)) return false;
        Cotizacion that = (Cotizacion) o;
        return Objects.equals(proveedores.getNombre(), that.proveedores.getNombre()) &&
                Objects.equals(inzumos.getNombre(), that.inzumos.getNombre()) &&
                Objects.equals(precio, that.precio);
    }

    @Override
    public int hashCode() {
       return Objects.hash(proveedores.getNombre(),inzumos.getNombre(),precio);
    }
}
