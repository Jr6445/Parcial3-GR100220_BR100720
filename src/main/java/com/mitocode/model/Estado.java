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
public class Estado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String Motivo;
    private boolean Activo;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "codEm", referencedColumnName = "id")
    private Empleados CodEm;
}