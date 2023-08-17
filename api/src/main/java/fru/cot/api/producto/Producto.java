/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fru.cot.api.producto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import fru.cot.api.DatosRegistroProducto;
import fru.cot.api.proveedor.Proveedor;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.util.HashSet;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ManyToAny;

/**
 *
 * @author Alejandro Rueda
 */
@Table(name="fruta")
@Entity(name="Producto")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@IdClass(ProductoId.class)
public class Producto {
    
    @Id
    @Column(name="proveedor_id")
    private long proveedorId;
    
    @Id
    private String nombre_fruta;
    private long precio_fruta;
    
      @ManyToMany(fetch = FetchType.LAZY,
      cascade = {
          CascadeType.PERSIST,
          CascadeType.MERGE
      },
      mappedBy = "productos")
      @JsonIgnore
      private Set<Proveedor> nombreProveedor = new HashSet<>();

      public Set<Proveedor> getNombreProveedor() {
          return nombreProveedor;
      }
    public void setNombreProveedor(Set<Proveedor> nombreProveedor) {
        this.nombreProveedor = nombreProveedor;
    }
    
    public Producto(DatosRegistroProducto datosRegistroProducto) {
        
        this.proveedorId = datosRegistroProducto.proveedor_id();
        this.nombre_fruta = datosRegistroProducto.nombre_fruta();
        this.precio_fruta = datosRegistroProducto.precio_fruta();
    }   
    
}
