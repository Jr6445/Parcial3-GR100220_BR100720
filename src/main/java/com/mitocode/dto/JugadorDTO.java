package com.mitocode.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class JugadorDTO {

    @EqualsAndHashCode.Include
    private Integer id;

    @NotNull
    private String nombre;

    @NotNull
    private CamisaDTO camisa;

    @NotNull
    private PosicionDTO posicion;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public CamisaDTO getCamisa() {
        return camisa;
    }

    public void setCamisa(CamisaDTO camisa) {
        this.camisa = camisa;
    }

    public PosicionDTO getPosicion() {
        return posicion;
    }

    public void setPosicion(PosicionDTO posicion) {
        this.posicion = posicion;
    }
}