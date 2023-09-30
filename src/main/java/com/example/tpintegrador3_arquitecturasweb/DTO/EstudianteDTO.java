package com.example.tpintegrador3_arquitecturasweb.DTO;


import lombok.Getter;

@Getter
public class EstudianteDTO {

    private int numeroDeDocumento;

    private String nombreCompleto;

    private int numeroDeLibretaUniversitaria;

    private String genero;

    private String ciudad;

    private String carrera;

    public EstudianteDTO(int numeroDeDocumento, String nombreCompleto, int numeroDeLibretaUniversitaria, String genero) {
        this.numeroDeDocumento = numeroDeDocumento;
        this.nombreCompleto = nombreCompleto;

        this.numeroDeLibretaUniversitaria = numeroDeLibretaUniversitaria;
        this.genero = genero;
    }

    public EstudianteDTO(int numeroDeDocumento, String nombreCompleto, String ciudad, String carrera) {
        this.numeroDeDocumento = numeroDeDocumento;
        this.nombreCompleto = nombreCompleto;
        this.ciudad = ciudad;
        this.carrera = carrera;
    }

    @Override
    public String toString() {
        return "EstudianteDTO{" +
                "numeroDeDocumento=" + numeroDeDocumento +
                ", nombreCompleto='" + nombreCompleto  + '\'' +
                ", numeroDeLibretaUniversitaria=" + numeroDeLibretaUniversitaria +
                ", genero='" + genero + '\'' +
                '}' + "\n";
    }
}