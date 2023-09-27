package com.example.tpintegrador3_arquitecturasweb.Servicio;

import com.example.tpintegrador3_arquitecturasweb.Modelo.Carrera;
import com.example.tpintegrador3_arquitecturasweb.Modelo.EstudianteCarrera;
import com.example.tpintegrador3_arquitecturasweb.Repositorio.CarreraRepositorio;
import com.example.tpintegrador3_arquitecturasweb.Repositorio.EstudianteCarreraRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
