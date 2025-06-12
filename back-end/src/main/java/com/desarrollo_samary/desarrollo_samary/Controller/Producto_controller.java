package com.desarrollo_samary.desarrollo_samary.Controller;

import com.desarrollo_samary.desarrollo_samary.Entity.Productos;
import com.desarrollo_samary.desarrollo_samary.Service.serviceProducto;
import com.desarrollo_samary.desarrollo_samary.Controller.Util.ApiResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/productos")
@CrossOrigin(origins = "*")
public class Producto_controller {

    private final serviceProducto service;

    public Producto_controller(serviceProducto service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<Productos>>> listarProductos() {
        List<Productos> lista = service.obtenerTodos();
        ApiResponse<List<Productos>> response = new ApiResponse<>(true, "Lista de productos", lista);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Productos>> obtenerPorId(@PathVariable Integer id) {
        Optional<Productos> producto = service.obtenerPorId(id);
        if (producto.isPresent()) {
            ApiResponse<Productos> response = new ApiResponse<>(true, "Producto encontrado", producto.get());
            return ResponseEntity.ok(response);
        } else {
            ApiResponse<Productos> response = new ApiResponse<>(false, "Producto no encontrado", null);
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Productos>> crearProducto(@RequestBody Productos producto) {
        Productos nuevo = service.guardar(producto);
        ApiResponse<Productos> response = new ApiResponse<>(true, "Producto creado exitosamente", nuevo);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Productos>> actualizar(@PathVariable Integer id, @RequestBody Productos producto) {
        producto.setId(id);
        Productos actualizado = service.guardar(producto);
        ApiResponse<Productos> response = new ApiResponse<>(true, "Producto actualizado", actualizado);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> eliminar(@PathVariable Integer id) {
        service.eliminar(id);
        ApiResponse<Void> response = new ApiResponse<>(true, "Producto eliminado", null);
        return ResponseEntity.ok(response);
    }
}


    

