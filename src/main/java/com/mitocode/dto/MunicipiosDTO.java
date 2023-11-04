package com.mitocode.dto;

import com.mitocode.model.Departamentos;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class MunicipiosDTO {

    @EqualsAndHashCode.Include
    private Integer id;
    private String nombreMuni;

    private Departamentos Depar;
}

