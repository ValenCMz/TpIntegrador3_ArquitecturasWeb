package com.example.tpintegrador3_arquitecturasweb.utils;

import com.example.tpintegrador3_arquitecturasweb.Modelo.Carrera;
import com.example.tpintegrador3_arquitecturasweb.Modelo.CarreraEstudianteKey;
import com.example.tpintegrador3_arquitecturasweb.Modelo.Estudiante;
import com.example.tpintegrador3_arquitecturasweb.Modelo.EstudianteCarrera;
import com.example.tpintegrador3_arquitecturasweb.Repositorio.CarreraRepositorio;
import com.example.tpintegrador3_arquitecturasweb.Repositorio.EstudianteCarreraRepositorio;
import com.example.tpintegrador3_arquitecturasweb.Repositorio.EstudianteRepositorio;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.FileReader;
import java.io.IOException;


@Component
public class CargaDeDatos {
    private final CarreraRepositorio carreraRepositorio;
    private final EstudianteRepositorio estudianteRepositorio;
    private final EstudianteCarreraRepositorio estudianteCarreraRepositorio;

    @Autowired
    public CargaDeDatos(CarreraRepositorio carreraRepositorio, EstudianteRepositorio estudianteRepositorio, EstudianteCarreraRepositorio estudianteCarreraRepositorio) {
        this.carreraRepositorio = carreraRepositorio;
        this.estudianteRepositorio = estudianteRepositorio;
        this.estudianteCarreraRepositorio = estudianteCarreraRepositorio;
    }

    public void cargarDatosCSV()throws IOException{
        CSVParser parser = null;
        try {
            parser = CSVFormat.DEFAULT.withHeader().parse(new FileReader("src/main/java/com/example/tpintegrador3_arquitecturasweb/csv/carreras.csv"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        for(CSVRecord row: parser) {
            carreraRepositorio.save(new Carrera(row.get("carrera")));
        }

        try {
            parser = CSVFormat.DEFAULT.withHeader().parse(new FileReader("src/main/java/com/example/tpintegrador3_arquitecturasweb/csv/estudiantes.csv"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        for (CSVRecord row: parser){
            estudianteRepositorio.save(new Estudiante(Integer.valueOf(row.get("LU")),row.get("nombre"),row.get("apellido"),Integer.valueOf(row.get("edad")),row.get("genero"),Integer.valueOf(row.get("DNI")),row.get("ciudad")));
        }

        try {
            parser = CSVFormat.DEFAULT.withHeader().parse(new FileReader("src/main/java/com/example/tpintegrador3_arquitecturasweb/csv/estudianteCarrera.csv"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        for (CSVRecord row: parser){
            estudianteCarreraRepositorio.save(new EstudianteCarrera(new CarreraEstudianteKey(Integer.valueOf(row.get("id_carrera")),Integer.valueOf(row.get("id_estudiante"))),carreraRepositorio.getPorId(Long.valueOf(row.get("id_carrera"))),estudianteRepositorio.getPorId(Long.valueOf(row.get("id_estudiante"))),Integer.valueOf(row.get("inscripcion")),Integer.valueOf(row.get("graduacion")),Integer.valueOf(row.get("antiguedad"))));
        }


    }
}
