package com.example.tpintegrador3_arquitecturasweb.Servicio;

import com.example.tpintegrador3_arquitecturasweb.DTO.EstudianteDTO;
import com.example.tpintegrador3_arquitecturasweb.DTO.EstudiantePorCarreraDTO;
import com.example.tpintegrador3_arquitecturasweb.Modelo.Estudiante;
import com.example.tpintegrador3_arquitecturasweb.Repositorio.EstudianteRepositorio;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service("EstudianteServicio")
public class EstudianteServicio implements BaseService<Estudiante> {

    @Autowired
    private EstudianteRepositorio estudianteRepositorio;

    @Override
    @Transactional
    public List<Estudiante> findAll() throws Exception {
        return this.estudianteRepositorio.findAll();
    }

    @Override
    @Transactional
    public Estudiante findById(Long id) throws Exception {
        return null;
    }

    @Override
    @Transactional
    public Estudiante save(Estudiante entity) throws Exception {
        return this.estudianteRepositorio.save(entity);
    }

    @Override
    @Transactional
    public Estudiante update(Long id, Estudiante entity) throws Exception {
        return null;
    }

    @Override
    @Transactional
    public boolean delete(Long id) throws Exception {
        return false;
    }

    @Transactional
    public List<EstudianteDTO> getEstudiantesOrdenadosPorApellido(){
        return this.estudianteRepositorio.getEstudiantesOrdenadosPorApellido().stream().map(e->new EstudianteDTO(e.getNumeroDeDocumento(),e.getNombre() + " " + e.getApellido(),e.getNumeroDeLibretaUniversitaria(),e.getGenero())).collect(Collectors.toList());
    }

    @Transactional
    public EstudianteDTO getEstudiantePorLibreta(int libreta){
        Estudiante e = this.estudianteRepositorio.getEstudiantePorLibreta(libreta);
        return new EstudianteDTO(e.getNumeroDeDocumento(),e.getNombre() + " " + e.getApellido(),e.getNumeroDeLibretaUniversitaria(),e.getGenero());
    }

    @Transactional
    public List<EstudianteDTO> getEstudiantesPorGenero(String genero){
        return this.estudianteRepositorio.getEstudiantesPorGenero(genero).stream().map(e->new EstudianteDTO(e.getNumeroDeDocumento(),e.getNombre() + " " + e.getApellido(),e.getNumeroDeLibretaUniversitaria(),e.getGenero())).collect(Collectors.toList());
    }
    @Transactional
    public List<EstudiantePorCarreraDTO> getEstudiantesPorCarreraYPorCiudad(int id_carrera, String ciudad){
        return this.estudianteRepositorio.getEstudiantesPorCarreraYPorCiudad(id_carrera,ciudad);
    }

}
