package com.proyedatabase.prodatabase.service;

import com.proyedatabase.prodatabase.modelo.LineaCredito;
import com.proyedatabase.prodatabase.repository.LineasCreditoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LineasCreditoServices {
    private final LineasCreditoRepository lineasCreditoRepository;

    public LineasCreditoServices(LineasCreditoRepository lineasCreditoRepository) {
        this.lineasCreditoRepository = lineasCreditoRepository;
    }

    public LineaCredito guardarLineasCredito(LineaCredito lc){
        return lineasCreditoRepository.save(lc);
    }



    public List<LineaCredito> consultarLineasCredito(){
        return lineasCreditoRepository.findAll();
    }

   /* public LineaCredito nobrelineaCredito(String nombre){

        return  lineasCreditoRepository.nombreCredito(nombre);
    }*/


    public List<LineaCredito> obtenerClientesPorNombre(String nombre) {
        return lineasCreditoRepository.findByNombre(nombre);
    }

}
