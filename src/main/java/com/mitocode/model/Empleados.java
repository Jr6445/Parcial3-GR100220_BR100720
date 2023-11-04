package com.mitocode.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Empleados {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String Apellidos;
    private String Nombres;

    private String genero;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "muni_id", referencedColumnName = "id")
    private Municipios muni;

    private String Telefono;
}