package com.proyedatabase.prodatabase.repository;

import com.proyedatabase.prodatabase.modelo.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente,String> {


    //List<Cliente> buscarPorNombre(String nombre);
    List<Cliente> findByNombre(String nombre);
    List<Cliente> findByNombreAndCorreo(String nombre, String correo);



}
