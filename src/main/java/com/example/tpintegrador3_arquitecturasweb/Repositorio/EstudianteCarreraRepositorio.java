package com.example.tpintegrador3_arquitecturasweb.Repositorio;

import com.example.tpintegrador3_arquitecturasweb.Modelo.Carrera;
import com.example.tpintegrador3_arquitecturasweb.Modelo.Estudiante;
import com.example.tpintegrador3_arquitecturasweb.Modelo.EstudianteCarrera;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EstudianteCarreraRepositorio extends JpaRepository<EstudianteCarrera,Integer> {

    @Query("SELECT ec FROM EstudianteCarrera ec JOIN ec.estudiante e JOIN ec.carrera c WHERE c.id = :id_carrera AND e.ciudadDeResidencia LIKE :ciudad")
    public List<EstudianteCarrera> getEstudiantesPorCarreraYPorCiudad(int id_carrera, String ciudad);

    @Query("SELECT ec FROM Carrera c JOIN c.estudiantes ec GROUP BY c.nombre,ec.inscripcion ORDER BY c.nombre,ec.inscripcion")
    public List<EstudianteCarrera> getReporteDeCarreras();

    @Query("SELECT count(ec) FROM Carrera c JOIN c.estudiantes ec GROUP BY c.nombre,ec.inscripcion ORDER BY c.nombre,ec.inscripcion")
    public List<Integer>cantidadDeInscriptos();

    @Query("SELECT SUM(CASE WHEN ec.graduacion > 0 THEN 1 ELSE 0 END) FROM Carrera c JOIN c.estudiantes ec GROUP BY c.nombre,ec.inscripcion ORDER BY c.nombre,ec.inscripcion")
    public List<Integer>cantidadDeEgresados();
}
