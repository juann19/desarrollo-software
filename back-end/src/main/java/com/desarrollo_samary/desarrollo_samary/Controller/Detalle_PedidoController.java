package com.desarrollo_samary.desarrollo_samary.Controller;

import com.desarrollo_samary.desarrollo_samary.Entity.Detalle_Pedido;
import com.desarrollo_samary.desarrollo_samary.Service.Detalle_PedidoService;
import com.desarrollo_samary.desarrollo_samary.Controller.Util.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/detalles")
@CrossOrigin(origins = "*")
public class Detalle_PedidoController {

    private final Detalle_PedidoService service;

    public Detalle_PedidoController(Detalle_PedidoService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<Detalle_Pedido>>> listarDetalles() {
        List<Detalle_Pedido> lista = service.obtenerTodos();
        return ResponseEntity.ok(new ApiResponse<>(true, "Lista de detalles de pedido", lista));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Detalle_Pedido>> obtenerPorId(@PathVariable Integer id) {
        Optional<Detalle_Pedido> detalle = service.obtenerPorId(id);
        if (detalle.isPresent()) {
            return ResponseEntity.ok(new ApiResponse<>(true, "Detalle encontrado", detalle.get()));
        } else {
            return new ResponseEntity<>(new ApiResponse<>(false, "Detalle no encontrado", null), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Detalle_Pedido>> crearDetalle(@RequestBody Detalle_Pedido detalle) {
        Detalle_Pedido nuevo = service.guardar(detalle);
        return new ResponseEntity<>(new ApiResponse<>(true, "Detalle creado exitosamente", nuevo), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Detalle_Pedido>> actualizar(@PathVariable Integer id, @RequestBody Detalle_Pedido detalle) {
        detalle.setId(id);
        Detalle_Pedido actualizado = service.guardar(detalle);
        return ResponseEntity.ok(new ApiResponse<>(true, "Detalle actualizado", actualizado));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> eliminar(@PathVariable Integer id) {
        service.eliminar(id);
        return ResponseEntity.ok(new ApiResponse<>(true, "Detalle eliminado", null));
    }
}
