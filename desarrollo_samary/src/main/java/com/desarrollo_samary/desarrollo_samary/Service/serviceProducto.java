// src/main/java/com/desarrollo_samary/desarrollo_samary/service/ProductoService.java

package com.desarrollo_samary.desarrollo_samary.Service;

import com.desarrollo_samary.desarrollo_samary.Entity.Productos;
import com.desarrollo_samary.desarrollo_samary.Repository.Producto_repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class serviceProducto {

    private final Producto_repository repository;

    public serviceProducto(Producto_repository repository) {
        this.repository = repository;
    }

    public List<Productos> obtenerTodos() {
        return repository.findAll();
    }
    public Optional<Productos> obtenerPorId(Integer id) {
        return repository.findById(id);
    }

    public Productos guardar(Productos producto) {
        return repository.save(producto);
    }

    public void eliminar(Integer id) {
        repository.deleteById(id);
    }
}

