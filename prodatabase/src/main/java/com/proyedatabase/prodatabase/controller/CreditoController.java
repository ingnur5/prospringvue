package com.proyedatabase.prodatabase.controller;

import com.proyedatabase.prodatabase.modelo.Cliente;
import com.proyedatabase.prodatabase.modelo.Creditos;
import com.proyedatabase.prodatabase.service.CreditoServicios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/creditos")
public class CreditoController {
    private final CreditoServicios creditoServicios;


    public CreditoController(CreditoServicios creditoServicios) {
        this.creditoServicios = creditoServicios;
    }

    @PostMapping
    public ResponseEntity<Creditos> crearCredito(@RequestBody Creditos creditos) {
        Creditos nuevoCredito = creditoServicios.guardarCredito(creditos);
        return new ResponseEntity<>(nuevoCredito, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Creditos>> listarCreditos() {
        List<Creditos> creditos = creditoServicios.consultarCreditos();
        return new ResponseEntity<>(creditos, HttpStatus.OK);
    }
}

