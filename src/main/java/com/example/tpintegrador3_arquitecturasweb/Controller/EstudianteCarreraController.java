package com.example.tpintegrador3_arquitecturasweb.Controller;

import com.example.tpintegrador3_arquitecturasweb.Modelo.Carrera;
import com.example.tpintegrador3_arquitecturasweb.Modelo.EstudianteCarrera;
import com.example.tpintegrador3_arquitecturasweb.Servicio.CarreraServicio;
import com.example.tpintegrador3_arquitecturasweb.Servicio.EstudianteCarreraServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/estudianteCarrera")
public class EstudianteCarreraController {

    @Autowired
    private EstudianteCarreraServicio estudianteCarreraServicio;

    public EstudianteCarreraController(EstudianteCarreraServicio estudianteCarreraServicio) {
        this.estudianteCarreraServicio = estudianteCarreraServicio;
    }

    @GetMapping("")
    public Iterable<EstudianteCarrera>getEstudiantesCarreras(){
        try {
            return this.estudianteCarreraServicio.findAll();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PostMapping("")
    public ResponseEntity<?> addEstudianteCarrera(@RequestBody EstudianteCarrera estudianteCarrera){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(this.estudianteCarreraServicio.save(estudianteCarrera));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error, no se pudo crear la relacion");
        }
    }

    @GetMapping("/carrera/{id_carrera}/ciudad/{ciudad}")
    public ResponseEntity<?>getEstudiantesPorCarreraYPorCiudad(@PathVariable int id_carrera,@PathVariable String ciudad){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(this.estudianteCarreraServicio.getEstudiantesPorCarreraYPorCiudad(id_carrera,ciudad));
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error, no hay estudiantes en esa carrera");
        }
    }

    @GetMapping("/reporte")
    public ResponseEntity<?> getReporteDeCarreras(){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(this.estudianteCarreraServicio.getReporteDeCarreras());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error, no se pudo generar el reporte");
        }
    }
}
