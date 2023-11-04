package com.mitocode.dto;

import com.mitocode.model.Empleados;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class EstadoDto {

    @EqualsAndHashCode.Include
    private Integer id;

    private String Motivo;
    private boolean Activo;

    private Empleados CodEm;
}
