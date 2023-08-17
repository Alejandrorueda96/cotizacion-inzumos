package fru.cot.api;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosRegistroProveedor(@NotBlank String nombre_vendedor) {
    
}
