package com.proyedatabase.prodatabase.controller;

import com.proyedatabase.prodatabase.modelo.LineaCredito;
import com.proyedatabase.prodatabase.service.LineasCreditoServices;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("lineas")
public class LineaDeCreditoController {
    private final LineasCreditoServices lineasCreditoServices;

    public LineaDeCreditoController(LineasCreditoServices lineasCreditoServices) {
        this.lineasCreditoServices = lineasCreditoServices;
    }
    @PostMapping
    public LineaCredito gusrdarLineas(@RequestBody LineaCredito lineaCredito){
        return  lineasCreditoServices.guardarLineasCredito(lineaCredito);
    }

   @GetMapping
    public List<LineaCredito> cosultarLineasCredito(){
        return  lineasCreditoServices.consultarLineasCredito();
    }



    @GetMapping("/clientes")
    public List<LineaCredito> obtenerClientes(@RequestParam String nombre) {
        return lineasCreditoServices.obtenerClientesPorNombre(nombre);
    }
}
