package com.mitocode.dto;

import com.mitocode.model.Municipios;
import lombok.*;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class EmpleadosDTO {

    @EqualsAndHashCode.Include
    private Integer id;
    private String Apellidos;
    private String Nombres;

    private String genero;

    private Municipios muni;

    private String Telefono;
}
