package com.proyedatabase.prodatabase.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
@Entity
public class LineaCredito {
    @Id
    private int codigo;
    private String nombre;
    private Long monto;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getMonto() {
        return monto;
    }

    public void setMonto(Long monto) {
        this.monto = monto;
    }

    public LineaCredito(int codigo, String nombre, Long monto) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.monto = monto;
    }
    public LineaCredito() {
    }
}
