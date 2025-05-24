// src/main/java/com/desarrollo_samary/desarrollo_samary/controller/ProductoController.java

package com.desarrollo_samary.desarrollo_samary.Controller;

import com.desarrollo_samary.desarrollo_samary.Entity.Productos;
import com.desarrollo_samary.desarrollo_samary.Service.serviceProducto;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/productos")
@CrossOrigin(origins = "*") // permite conexiones desde el frontend local
public class Producto_controller {


    private final serviceProducto service;

    public Producto_controller(serviceProducto service) {
        this.service = service;
    }

    @GetMapping
    public List<Productos> listarProductos() {
        return service.obtenerTodos();
    }
    @GetMapping("/{id}")
    public  Optional<Productos> obtenerPorId(@PathVariable Integer id) {
        return service.obtenerPorId(id);
    }

    @PostMapping
    public Productos crear(@RequestBody Productos producto) {
        return service.guardar(producto);
    }

    @PutMapping("/{id}")
    public Productos actualizar(@PathVariable Integer id, @RequestBody Productos producto) {
        producto.setId(id);
        return service.guardar(producto);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        service.eliminar(id);
    }
}

    

