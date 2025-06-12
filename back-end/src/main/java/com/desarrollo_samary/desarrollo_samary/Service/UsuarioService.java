package com.desarrollo_samary.desarrollo_samary.Service;

import com.desarrollo_samary.desarrollo_samary.Entity.Usuario;
import com.desarrollo_samary.desarrollo_samary.Repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public List<Usuario> obtenerTodos() {
        return repository.findAll();
    }

    public Optional<Usuario> obtenerPorId(Integer id) {
        return repository.findById(id);
    }

    public Usuario guardar(Usuario usuario) {
        return repository.save(usuario);
    }

    public void eliminar(Integer id) {
        repository.deleteById(id);
    }
}

