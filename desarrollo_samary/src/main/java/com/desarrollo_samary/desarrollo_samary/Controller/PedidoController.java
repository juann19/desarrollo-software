package com.desarrollo_samary.desarrollo_samary.Controller;
import com.desarrollo_samary.desarrollo_samary.Entity.Pedido;
import com.desarrollo_samary.desarrollo_samary.Service.PedidoService;
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
    public List<Pedido> listar() {
        return service.obtenerTodos();
    }

    @GetMapping("/{id}")
    public Optional<Pedido> obtener(@PathVariable Integer id) {
        return service.obtenerPorId(id);
    }

    @PostMapping
    public Pedido crear(@RequestBody Pedido pedido) {
        return service.guardar(pedido);
    }

    @PutMapping("/{id}")
    public Pedido actualizar(@PathVariable Integer id, @RequestBody Pedido pedido) {
        pedido.setId(id);
        return service.guardar(pedido);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        service.eliminar(id);
    }

    @GetMapping("/completo")
    public List<Pedido> listarConDetalles() {
        return service.obtenerTodos();
    }
}

