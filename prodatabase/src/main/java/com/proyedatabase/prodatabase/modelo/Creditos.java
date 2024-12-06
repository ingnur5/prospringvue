package com.proyedatabase.prodatabase.modelo;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Creditos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idcredito;


    @ManyToOne
    @JoinColumn(name = "documento", referencedColumnName = "documento", nullable = false)
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "coigo")
    private LineaCredito linea;

    private LocalDate fechaDeDesenbolso;
    private Double  monto;

    public Creditos(int idcredito, Cliente cliente, LineaCredito linea, LocalDate fechaDeDesenbolso, Double monto) {
        this.idcredito = idcredito;
        this.cliente = cliente;
        this.linea = linea;
        this.fechaDeDesenbolso = fechaDeDesenbolso;
        this.monto = monto;
      }

    public int getIdcredito() {
        return idcredito;
    }

    public void setIdcredito(int idcredito) {
        this.idcredito = idcredito;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public LineaCredito getLinea() {
        return linea;
    }

    public void setLinea(LineaCredito linea) {
        this.linea = linea;
    }

    public LocalDate getFechaDeDesenbolso() {
        return fechaDeDesenbolso;
    }

    public void setFechaDeDesenbolso(LocalDate fechaDeDesenbolso) {
        this.fechaDeDesenbolso = fechaDeDesenbolso;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public Creditos() {
    }








}
