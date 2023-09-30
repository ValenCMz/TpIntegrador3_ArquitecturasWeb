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

    @Query("SELECT NEW com.example.tpintegrador3_arquitecturasweb.DTO.CarreraDTO(c.id, c.nombre, COUNT(e)) FROM Carrera  c JOIN c.estudiantes e GROUP BY c.id,c.nombre ORDER BY COUNT(e) ")
    public List<CarreraDTO> getCarrerasConInscriptos();

    @Query("SELECT new  com.example.tpintegrador3_arquitecturasweb.DTO.CarreraReporteDTO(c.nombre,ec.inscripcion,count(ec),SUM(CASE WHEN ec.graduacion > 0 THEN 1 ELSE 0 END)) FROM Carrera c JOIN c.estudiantes ec GROUP BY c.nombre,ec.inscripcion ORDER BY c.nombre,ec.inscripcion")
    public List<CarreraReporteDTO> getReporteDeCarreras();
}
