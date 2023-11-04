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
public class SueldoDTO {

    @EqualsAndHashCode.Include
    private Integer id;

    private double salario;

    private double salarioLi;

    private Empleados CodEmS;



}
