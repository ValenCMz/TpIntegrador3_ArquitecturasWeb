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
    public ResponseEntity<?>getEstudiantes(){
       try {
           return ResponseEntity.status(HttpStatus.OK).body(this.estudianteServicio.findAll());
       } catch (Exception e) {
           return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error, no hay estudiantes");
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

   @GetMapping("/estudiantesOrdenadosPorApellido")
    public ResponseEntity<?>getEstudiantesOrdenadosPorApellido(){
       try{
            return ResponseEntity.status(HttpStatus.OK).body(this.estudianteServicio.getEstudiantesOrdenadosPorApellido());
       }
       catch (Exception e){
           return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error, no hay estudiantes");
       }
   }

   @GetMapping("/estudiantePorLibreta/{libreta}")
   public ResponseEntity<?>getEstudiantePorLibreta(@PathVariable int libreta){
       try{
           return ResponseEntity.status(HttpStatus.OK).body(this.estudianteServicio.getEstudiantePorLibreta(libreta));
       }
       catch (Exception e){
           return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error, no se encontro el estudiante");
       }
   }

    @GetMapping("/estudiantesPorGenero/{genero}")
    public ResponseEntity<?>getEstudiantesPorGenero(@PathVariable String genero){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(this.estudianteServicio.getEstudiantesPorGenero(genero));
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error, no hay estudiantes");
        }
    }

    @GetMapping("/{id_carrera}/{ciudad}")
    public ResponseEntity<?>getEstudiantesPorCarreraYPorCiudad(@PathVariable int id_carrera,@PathVariable String ciudad){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(this.estudianteServicio.getEstudiantesPorCarreraYPorCiudad(id_carrera,ciudad));
        }
        catch (Exception e){
            System.out.println("ERRORORR:" + e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error, no hay estudiantes en esa carrera");
        }
    }

}
