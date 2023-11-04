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
public class Sueldo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private double salario;

    private double salarioLi;
    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "codEmS", referencedColumnName = "id")
    private Empleados CodEmS;
}
