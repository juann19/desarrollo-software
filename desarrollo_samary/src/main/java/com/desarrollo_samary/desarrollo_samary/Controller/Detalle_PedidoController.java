package com.desarrollo_samary.desarrollo_samary.Controller;
import com.desarrollo_samary.desarrollo_samary.Entity.Detalle_Pedido;
import com.desarrollo_samary.desarrollo_samary.Service.Detalle_PedidoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/detalle_pedido")
@CrossOrigin(origins = "*")
public class Detalle_PedidoController {

    private final Detalle_PedidoService service;

    public Detalle_PedidoController(Detalle_PedidoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Detalle_Pedido> listar() {
        return service.obtenerTodos();
    }

    @GetMapping("/{id}")
    public Optional<Detalle_Pedido> obtenerPorId(@PathVariable Integer id) {
        return service.obtenerPorId(id);
    }

    @PostMapping
    public Detalle_Pedido crear(@RequestBody Detalle_Pedido detalle) {
        return service.guardar(detalle);
    }

    @PutMapping("/{id}")
    public Detalle_Pedido actualizar(@PathVariable Integer id, @RequestBody Detalle_Pedido detalle) {
        detalle.setId(id);
        return service.guardar(detalle);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        service.eliminar(id);
    }
}

