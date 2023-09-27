package com.example.tpintegrador3_arquitecturasweb.Controller;

import com.example.tpintegrador3_arquitecturasweb.Modelo.Estudiante;
import com.example.tpintegrador3_arquitecturasweb.Servicio.EstudianteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/estudiantes")
public class EstudianteController {

    @Autowired
    private EstudianteServicio estudianteServicio;

   @GetMapping("")
    public Iterable<Estudiante>getEstudiantes(){
       try {
           return this.estudianteServicio.findAll();
       } catch (Exception e) {
           throw new RuntimeException(e);
       }
   }

   @PostMapping("")
    public ResponseEntity<?> darDeAlta(@RequestBody Estudiante estudiante){
       try {
           return ResponseEntity.status(HttpStatus.OK).body(this.estudianteServicio.save(estudiante));
       } catch (Exception e) {
           return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error, no se pudo dar de alta el estudiante. Controle sus campos");
       }
   }
}
