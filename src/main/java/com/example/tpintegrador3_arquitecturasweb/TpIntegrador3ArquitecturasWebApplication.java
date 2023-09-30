package com.example.tpintegrador3_arquitecturasweb;

import com.example.tpintegrador3_arquitecturasweb.utils.CargaDeDatos;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class TpIntegrador3ArquitecturasWebApplication {

    @Autowired
    private CargaDeDatos cargaDeDatos;

    public static void main(String[] args) {
        SpringApplication.run(TpIntegrador3ArquitecturasWebApplication.class, args);
    }

    @PostConstruct
    public void init()throws IOException{
    cargaDeDatos.cargarDatosCSV();
    }
}
