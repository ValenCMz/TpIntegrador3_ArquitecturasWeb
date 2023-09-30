package com.example.tpintegrador3_arquitecturasweb.Servicio;

import com.example.tpintegrador3_arquitecturasweb.DTO.CarreraDTO;
import com.example.tpintegrador3_arquitecturasweb.DTO.CarreraReporteDTO;
import com.example.tpintegrador3_arquitecturasweb.Modelo.Carrera;
import com.example.tpintegrador3_arquitecturasweb.Repositorio.CarreraRepositorio;
import com.example.tpintegrador3_arquitecturasweb.Repositorio.EstudianteRepositorio;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("CarreraServicio")
public class CarreraServicio implements BaseService<Carrera>{

    @Autowired
    private CarreraRepositorio carreraRepositorio;

    @Override
    @Transactional
    public List<Carrera> findAll() throws Exception {
       return this.carreraRepositorio.findAll();
    }

    @Override
    @Transactional
    public Carrera findById(Long id) throws Exception {
        return null;
    }

    @Override
    @Transactional
    public Carrera save(Carrera entity) throws Exception {
        return this.carreraRepositorio.save(entity);
    }

    @Override
    @Transactional
    public Carrera update(Long id, Carrera entity) throws Exception {
        return null;
    }

    @Override
    @Transactional
    public boolean delete(Long id) throws Exception {
        return false;
    }

    @Transactional
    public List<CarreraDTO>getCarrerasConInscriptos(){
        return this.carreraRepositorio.getCarrerasConInscriptos();
    }

    @Transactional
    public List<CarreraReporteDTO>getReporteDeCarreras(){
        return this.carreraRepositorio.getReporteDeCarreras();
    }
}
