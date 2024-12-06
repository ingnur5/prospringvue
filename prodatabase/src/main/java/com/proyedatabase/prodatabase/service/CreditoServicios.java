package com.proyedatabase.prodatabase.service;

import com.proyedatabase.prodatabase.modelo.Cliente;
import com.proyedatabase.prodatabase.modelo.Creditos;
import com.proyedatabase.prodatabase.modelo.LineaCredito;
import com.proyedatabase.prodatabase.repository.ClienteRepository;
import com.proyedatabase.prodatabase.repository.CreditoRepository;
import com.proyedatabase.prodatabase.repository.LineasCreditoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
@Service
public class CreditoServicios {
    private final CreditoRepository creditoRepository;
    private final ClienteRepository clienteRepository;
    private final LineasCreditoRepository lineasCreditoRepository;


    public CreditoServicios(CreditoRepository creditoRepository, ClienteRepository clienteRepository, LineasCreditoRepository lineasCreditoRepository) {
        this.creditoRepository = creditoRepository;
        this.clienteRepository = clienteRepository;
        this.lineasCreditoRepository = lineasCreditoRepository;
    }

    public Creditos guardarCredito(Creditos creditos) {
        // Buscar y asignar el cliente
        Cliente cliente = clienteRepository.findById(creditos.getCliente().getDocumento())
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));


        // Buscar y asignar la línea de crédito
        LineaCredito lineaCredito = lineasCreditoRepository.findById(creditos.getLinea().getCodigo())
                .orElseThrow(() -> new RuntimeException("Línea de crédito no encontrada"));

        // Asignar las entidades relacionadas al objeto Creditos
        creditos.setCliente(cliente);
        creditos.setLinea(lineaCredito);

        // Guardar la entidad Creditos
        return creditoRepository.save(creditos);
    }

    public List<Creditos> consultarCreditos() {
        return creditoRepository.findAll();
    }
}

