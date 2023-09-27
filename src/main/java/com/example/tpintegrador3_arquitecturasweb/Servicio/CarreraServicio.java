package com.example.tpintegrador3_arquitecturasweb.Servicio;

import com.example.tpintegrador3_arquitecturasweb.Modelo.Carrera;
import com.example.tpintegrador3_arquitecturasweb.Repositorio.CarreraRepositorio;
import com.example.tpintegrador3_arquitecturasweb.Repositorio.EstudianteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("CarreraServicio")
public class CarreraServicio implements BaseService<Carrera>{

    @Autowired
    private CarreraRepositorio carreraRepositorio;

    @Override
    public List<Carrera> findAll() throws Exception {
       return this.carreraRepositorio.findAll();
    }

    @Override
    public Carrera findById(Long id) throws Exception {
        return null;
    }

    @Override
    public Carrera save(Carrera entity) throws Exception {
        return this.carreraRepositorio.save(entity);
    }

    @Override
    public Carrera update(Long id, Carrera entity) throws Exception {
        return null;
    }

    @Override
    public boolean delete(Long id) throws Exception {
        return false;
    }
}
