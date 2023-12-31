package com.example.tpintegrador3_arquitecturasweb.DTO;

import lombok.Getter;

@Getter
public class CarreraDTO {

    private int id;

    private String nombre;

    private Integer cantidadDeInscriptos;

    public CarreraDTO(int id, String nombre, Integer cantidadDeInscriptos) {
        this.id = id;
        this.nombre = nombre;
        this.cantidadDeInscriptos = cantidadDeInscriptos;
    }


    @Override
    public String toString() {
        return "CarreraDTO{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", cantidadDeInscriptos=" + cantidadDeInscriptos +
                '}' + "\n";
    }
}

