package com.proyedatabase.prodatabase.repository;

import com.proyedatabase.prodatabase.modelo.Cliente;
import com.proyedatabase.prodatabase.modelo.LineaCredito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LineasCreditoRepository extends JpaRepository<LineaCredito,Integer> {

    //LineaCredito nombreCredito(String nombre);

    @Query("SELECT c FROM Cliente c WHERE c.nombre = :nombre")
    List<LineaCredito> findByNombre(@Param("nombre") String nombre);

}
