package com.proyedatabase.prodatabase.repository;

import com.proyedatabase.prodatabase.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UusuarioRepository extends JpaRepository<Usuario, String> {
}
