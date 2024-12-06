package com.proyedatabase.prodatabase.modelo;

import jakarta.persistence.*;

@Entity
public class Usuario {

    @Id
    @Column(name="documento_cliente")
    private String documento;
    private String nombreUusario;
    private String clave;

    @OneToOne
    @MapsId
    @JoinColumn(name="documento_cliente")
    private Cliente cliente;



}
