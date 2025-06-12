package com.desarrollo_samary.desarrollo_samary.Repository;


import com.desarrollo_samary.desarrollo_samary.Entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
}
