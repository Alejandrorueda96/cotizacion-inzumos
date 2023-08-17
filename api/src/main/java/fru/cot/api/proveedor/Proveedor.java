 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 * DTO
*/
package fru.cot.api.proveedor;
import fru.cot.api.DatosRegistroProveedor;
import fru.cot.api.producto.Producto;
import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
/**
 *
 * @author Alejandro Rueda
 */
@Table(name = "proveedor")
@Entity(name = "Proveedor")
@Getter
@NoArgsConstructor
@AllArgsConstructor
//@EqualsAndHashCode(of = "proveedor_id")
public class Proveedor {
    
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "proveedor_id")
    private long proveedorId;
    private String nombre_vendedor;
    
    @ManyToMany(fetch = FetchType.LAZY, cascade = {
        CascadeType.PERSIST,
        CascadeType.MERGE
    })
    @JoinTable(name = "nombre_precio",
            joinColumns = {@JoinColumn(name = "nombre_vendedor")},
            inverseJoinColumns = {@JoinColumn(name = "precio_fruta"),@JoinColumn(name="nombre_fruta")}
    )
    private Set<Producto> productos = new HashSet<>();
    public Proveedor(DatosRegistroProveedor datosRegistroProveedor) {
        this.nombre_vendedor = datosRegistroProveedor.nombre_vendedor();
    }
    
    public void actualizarDatos(DatosActualizarProveedor datosActualizarProveedor){
        if(datosActualizarProveedor.nombre_vendedor() != null) {
            this.nombre_vendedor = datosActualizarProveedor.nombre_vendedor();
        }
        
    }
}
