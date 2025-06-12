package com.desarrollo_samary.desarrollo_samary.Controller;

import com.desarrollo_samary.desarrollo_samary.Entity.Pedido;
import com.desarrollo_samary.desarrollo_samary.Service.PedidoService;
import com.desarrollo_samary.desarrollo_samary.Controller.Util.ApiResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/pedidos")
@CrossOrigin(origins = "*")
public class PedidoController {

    private final PedidoService service;

    public PedidoController(PedidoService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<Pedido>>> listarPedidos() {
        List<Pedido> lista = service.obtenerTodos();
        return ResponseEntity.ok(new ApiResponse<>(true, "Lista de pedidos", lista));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Pedido>> obtenerPorId(@PathVariable Integer id) {
        Optional<Pedido> pedido = service.obtenerPorId(id);
        if (pedido.isPresent()) {
            return ResponseEntity.ok(new ApiResponse<>(true, "Pedido encontrado", pedido.get()));
        } else {
            return new ResponseEntity<>(new ApiResponse<>(false, "Pedido no encontrado", null), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Pedido>> crearPedido(@RequestBody Pedido pedido) {
        Pedido nuevo = service.guardar(pedido);
        return new ResponseEntity<>(new ApiResponse<>(true, "Pedido creado exitosamente", nuevo), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Pedido>> actualizar(@PathVariable Integer id, @RequestBody Pedido pedido) {
        pedido.setId(id);
        Pedido actualizado = service.guardar(pedido);
        return ResponseEntity.ok(new ApiResponse<>(true, "Pedido actualizado", actualizado));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> eliminar(@PathVariable Integer id) {
        service.eliminar(id);
        return ResponseEntity.ok(new ApiResponse<>(true, "Pedido eliminado", null));
    }
}
