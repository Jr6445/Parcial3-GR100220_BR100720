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
public class Municipios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombreMuni;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "depar_id", referencedColumnName = "id")
    private Departamentos Depar;
}