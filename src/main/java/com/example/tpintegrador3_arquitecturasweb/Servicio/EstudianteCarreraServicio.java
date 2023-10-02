package com.example.tpintegrador3_arquitecturasweb.Servicio;

import com.example.tpintegrador3_arquitecturasweb.DTO.CarreraReporteDTO;
import com.example.tpintegrador3_arquitecturasweb.DTO.EstudiantePorCarreraDTO;
import com.example.tpintegrador3_arquitecturasweb.Modelo.Carrera;
import com.example.tpintegrador3_arquitecturasweb.Modelo.EstudianteCarrera;
import com.example.tpintegrador3_arquitecturasweb.Repositorio.CarreraRepositorio;
import com.example.tpintegrador3_arquitecturasweb.Repositorio.EstudianteCarreraRepositorio;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("EstudianteCarreraServicio")
public class EstudianteCarreraServicio implements BaseService<EstudianteCarrera>{


    @Autowired
    private EstudianteCarreraRepositorio estudianteCarreraRepositorio;

    public EstudianteCarreraServicio(EstudianteCarreraRepositorio estudianteCarreraRepositorio) {
        this.estudianteCarreraRepositorio = estudianteCarreraRepositorio;
    }


    @Override
    public List<EstudianteCarrera> findAll() throws Exception {
        return estudianteCarreraRepositorio.findAll();
    }

    @Override
    public EstudianteCarrera findById(Long id) throws Exception {
        return null;
    }

    @Override
    public EstudianteCarrera save(EstudianteCarrera entity) throws Exception {
        return this.estudianteCarreraRepositorio.save(entity);
    }

    @Override
    public EstudianteCarrera update(Long id, EstudianteCarrera entity) throws Exception {
        return null;
    }

    @Override
    public boolean delete(Long id) throws Exception {
        return false;
    }

    @Transactional
    public List<EstudiantePorCarreraDTO> getEstudiantesPorCarreraYPorCiudad(int id_carrera, String ciudad){
        return this.estudianteCarreraRepositorio.getEstudiantesPorCarreraYPorCiudad(id_carrera,ciudad).stream().map(e-> new EstudiantePorCarreraDTO(e.getEstudiante().getNumeroDeDocumento(),e.getEstudiante().getNombre() + " " + e.getEstudiante().getApellido(), e.getCarrera().getNombre(),e.getEstudiante().getCiudadDeResidencia())).toList();
    }

    @Transactional
    public List<CarreraReporteDTO>getReporteDeCarreras(){
        List<EstudianteCarrera>estudianteCarreras = this.estudianteCarreraRepositorio.getReporteDeCarreras();
        List<Integer>inscriptos = this.estudianteCarreraRepositorio.cantidadDeInscriptos();
        List<Integer>egresados  = this.estudianteCarreraRepositorio.cantidadDeEgresados();
        List<CarreraReporteDTO>toReturn = new ArrayList<>();
        for(int i = 0;i<estudianteCarreras.size();i++){
            EstudianteCarrera estudianteCarrera = estudianteCarreras.get(i);
            Integer cantInscriptos = inscriptos.get(i);
            Integer cantEgresados = egresados.get(i);
            toReturn.add(new CarreraReporteDTO(estudianteCarrera.getCarrera().getNombre(),estudianteCarrera.getInscripcion(),cantInscriptos,cantEgresados));
        }

        return toReturn;

    }
}
