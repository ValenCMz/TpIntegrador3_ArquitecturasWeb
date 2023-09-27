package com.example.tpintegrador3_arquitecturasweb.Servicio;

import com.example.tpintegrador3_arquitecturasweb.Modelo.Estudiante;
import com.example.tpintegrador3_arquitecturasweb.Repositorio.EstudianteRepositorio;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
