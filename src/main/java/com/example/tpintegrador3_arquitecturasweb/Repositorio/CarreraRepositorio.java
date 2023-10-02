package com.example.tpintegrador3_arquitecturasweb.Repositorio;

import com.example.tpintegrador3_arquitecturasweb.DTO.CarreraDTO;
import com.example.tpintegrador3_arquitecturasweb.DTO.CarreraReporteDTO;
import com.example.tpintegrador3_arquitecturasweb.Modelo.Carrera;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CarreraRepositorio extends JpaRepository<Carrera,Long> {

    @Query("Select c FROM Carrera c WHERE c.id = :id")
    public Carrera getPorId(Long id);

    @Query("SELECT c FROM Carrera  c JOIN c.estudiantes e GROUP BY c.id,c.nombre ORDER BY COUNT(e) ")
    public List<Carrera> getCarrerasConInscriptos();

    @Query("SELECT COUNT(e) FROM Carrera  c JOIN c.estudiantes e GROUP BY c.id,c.nombre ORDER BY COUNT(e) ")
    public List<Integer> cantidadCarrerasConInscriptos();


}
