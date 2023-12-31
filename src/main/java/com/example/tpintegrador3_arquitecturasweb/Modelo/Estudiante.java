package com.example.tpintegrador3_arquitecturasweb.Modelo;


import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Estudiante {

    @Id
    private int numeroDeDocumento;

    @Column
    private int numeroDeLibretaUniversitaria;

    @Column
    private String nombre;

    @Column
    private String apellido;

    @Column
    private int edad;

    @Column
    private String genero;

    private String ciudadDeResidencia;


    @OneToMany(mappedBy = "estudiante")
    private List<EstudianteCarrera> carreras;

    public Estudiante(int numeroDeLibretaUniversitaria, String nombre, String apellido, int edad, String genero, int numeroDeDocumento, String ciudadDeResidencia) {
        this.numeroDeLibretaUniversitaria = numeroDeLibretaUniversitaria;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.genero = genero;
        this.numeroDeDocumento = numeroDeDocumento;
        this.ciudadDeResidencia = ciudadDeResidencia;
      //  this.carreras = new ArrayList<>();
    }

    public Estudiante() {

    }

    public int getNumeroDeLibretaUniversitaria() {
        return numeroDeLibretaUniversitaria;
    }

    public void setNumeroDeLibretaUniversitaria(int numeroDeLibretaUniversitaria) {
        this.numeroDeLibretaUniversitaria = numeroDeLibretaUniversitaria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getNumeroDeDocumento() {
        return numeroDeDocumento;
    }

    public void setNumeroDeDocumento(int numeroDeDocumento) {
        this.numeroDeDocumento = numeroDeDocumento;
    }

    public String getCiudadDeResidencia() {
        return ciudadDeResidencia;
    }

    public void setCiudadDeResidencia(String ciudadDeResidencia) {
        this.ciudadDeResidencia = ciudadDeResidencia;
    }

    /*
    public List<EstudianteCarrera> getCarreras() {
        return carreras;
    }

    public void setCarreras(List<EstudianteCarrera> carreras) {
        this.carreras = carreras;
    }

    public void addCarrera(EstudianteCarrera ec){
        this.carreras.add(ec);
    }

     */
}
