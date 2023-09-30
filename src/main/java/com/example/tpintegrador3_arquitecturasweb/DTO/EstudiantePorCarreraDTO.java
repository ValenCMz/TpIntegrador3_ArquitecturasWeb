package com.example.tpintegrador3_arquitecturasweb.DTO;

import lombok.Getter;

@Getter
public class EstudiantePorCarreraDTO {
    private int numeroDeDocumento;

    private String nombreCompleto;

    private String carrera;

    private String ciudadResidencia;

    public EstudiantePorCarreraDTO(int numeroDeDocumento, String nombreCompleto, String carrera, String ciudadResidencia) {
        this.numeroDeDocumento = numeroDeDocumento;
        this.nombreCompleto = nombreCompleto;
        this.carrera = carrera;
        this.ciudadResidencia = ciudadResidencia;
    }

    @Override
    public String toString() {
        return "EstudiantePorCarreraDTO{" +
                "numeroDeDocumento=" + numeroDeDocumento +
                ", nombreCompleto='" + nombreCompleto + '\'' +
                ", carrera=" + carrera +
                ", ciudadResidencia='" + ciudadResidencia + '\'' +
                '}' + "\n";
    }
}