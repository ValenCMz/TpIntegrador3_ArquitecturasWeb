package com.example.tpintegrador3_arquitecturasweb.Repositorio;

import com.example.tpintegrador3_arquitecturasweb.DTO.EstudianteDTO;
import com.example.tpintegrador3_arquitecturasweb.DTO.EstudiantePorCarreraDTO;
import com.example.tpintegrador3_arquitecturasweb.Modelo.Carrera;
import com.example.tpintegrador3_arquitecturasweb.Modelo.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface EstudianteRepositorio extends JpaRepository<Estudiante,Long> {

    @Query("Select e FROM Estudiante e WHERE e.numeroDeDocumento = :id")
    public Estudiante getPorId(Long id);


    @Query("SELECT e FROM Estudiante e ORDER BY e.apellido")
    public List<Estudiante> getEstudiantesOrdenadosPorApellido();

    @Query("SELECT e FROM Estudiante e WHERE e.numeroDeLibretaUniversitaria = :libreta")
    public Estudiante getEstudiantePorLibreta(int libreta);

    @Query("SELECT e FROM Estudiante e WHERE e.genero LIKE :genero")
    public List<Estudiante> getEstudiantesPorGenero(String genero);


}
