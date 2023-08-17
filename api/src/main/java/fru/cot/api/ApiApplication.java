package fru.cot.api;

import fru.cot.api.cotizacion.Cotizacion;
import fru.cot.api.proveedor.Proveedor;
import fru.cot.api.proveedor.ProveedorRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class ApiApplication {
private ProveedorRepository proveedorRepository;

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
		ApiApplication aplicacion = new ApiApplication();
	 
                
	}
}
