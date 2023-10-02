package com.example.tpintegrador3_arquitecturasweb.Controller;

import com.example.tpintegrador3_arquitecturasweb.Modelo.Carrera;
import com.example.tpintegrador3_arquitecturasweb.Modelo.Estudiante;
import com.example.tpintegrador3_arquitecturasweb.Servicio.CarreraServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/carreras")
public class CarreraController {

    @Autowired
    private CarreraServicio carreraServicio;

    public CarreraController(CarreraServicio carreraServicio) {
        this.carreraServicio = carreraServicio;
    }

    @GetMapping("")
    public Iterable<Carrera>getCarreras(){
        try {
            return this.carreraServicio.findAll();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PostMapping("")
    public ResponseEntity<?> darDeAlta(@RequestBody Carrera carrera){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(this.carreraServicio.save(carrera));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error, no se pudo dar de alta la carrera. Controle sus campos");
        }
    }

    @GetMapping("/ConInscriptos")
    public ResponseEntity<?> getCarrerasConInscriptos(){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(this.carreraServicio.getCarrerasConInscriptos());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error, no se pudo dar de alta la carrera. Controle sus campos");
        }
    }

}
