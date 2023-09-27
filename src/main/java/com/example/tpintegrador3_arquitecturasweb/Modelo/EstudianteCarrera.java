package com.example.tpintegrador3_arquitecturasweb.Modelo;

import jakarta.persistence.*;

@Entity
public class EstudianteCarrera {

    @EmbeddedId
    private CarreraEstudianteKey id;

    @ManyToOne
    @MapsId("carreraId")
    @JoinColumn(name = "carrera_id")
    private Carrera carrera;

    @ManyToOne
    @MapsId("estudianteId")
    @JoinColumn(name = "estudiante_id")
    private Estudiante estudiante;
    @Column
    private int antiguedad;
    @Column
    private int inscripcion;
    @Column
    private int graduacion;

    public EstudianteCarrera(CarreraEstudianteKey id, Carrera carrera, Estudiante estudiante, int antiguedad, int inscripcion, int graduacion) {
        this.id = id;
        this.carrera = carrera;
        this.estudiante = estudiante;
        this.antiguedad = antiguedad;
        this.inscripcion = inscripcion;
        this.graduacion = graduacion;
    }

    public EstudianteCarrera() {

    }

    public CarreraEstudianteKey getId() {
        return id;
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public int getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(int antiguedad) {
        this.antiguedad = antiguedad;
    }

    public int getInscripcion() {
        return inscripcion;
    }

    public void setInscripcion(int inscripcion) {
        this.inscripcion = inscripcion;
    }

    public int getGraduacion() {
        return graduacion;
    }

    public void setGraduacion(int graduacion) {
        this.graduacion = graduacion;
    }
}
