package com.example.tpintegrador3_arquitecturasweb.Repositorio;

import com.example.tpintegrador3_arquitecturasweb.Modelo.Carrera;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CarreraRepositorio extends JpaRepository<Carrera,Long> {

    @Query("Select c FROM Carrera c WHERE c.id = :id")
    public Carrera getPorId(Long id);
}
