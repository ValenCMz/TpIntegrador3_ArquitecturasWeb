package com.example.tpintegrador3_arquitecturasweb.Repositorio;

import com.example.tpintegrador3_arquitecturasweb.Modelo.Carrera;
import com.example.tpintegrador3_arquitecturasweb.Modelo.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


public interface EstudianteRepositorio extends JpaRepository<Estudiante,Long> {

    @Query("Select e FROM Estudiante e WHERE e.numeroDeDocumento = :id")
    public Estudiante getPorId(Long id);
}
