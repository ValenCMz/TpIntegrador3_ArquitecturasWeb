package com.example.tpintegrador3_arquitecturasweb.Servicio;

import com.example.tpintegrador3_arquitecturasweb.DTO.CarreraDTO;
import com.example.tpintegrador3_arquitecturasweb.DTO.CarreraReporteDTO;
import com.example.tpintegrador3_arquitecturasweb.Modelo.Carrera;
import com.example.tpintegrador3_arquitecturasweb.Repositorio.CarreraRepositorio;
import com.example.tpintegrador3_arquitecturasweb.Repositorio.EstudianteRepositorio;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        return this.carreraRepositorio.getPorId(id);
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
        List<Carrera>carreras = this.carreraRepositorio.getCarrerasConInscriptos();
        List<Integer>cantidades = this.carreraRepositorio.cantidadCarrerasConInscriptos();
        List<CarreraDTO>toReturn = new ArrayList<>();

        for(int i = 0; i<carreras.size();i++){
            Carrera carrera = carreras.get(i);
            Integer cantidad = cantidades.get(i);
            toReturn.add(new CarreraDTO(carrera.getId(),carrera.getNombre(),cantidad));
        }

        return toReturn;
    }

}
