package com.desarrollo_samary.desarrollo_samary.Service;
import com.desarrollo_samary.desarrollo_samary.Entity.Detalle_Pedido;
import com.desarrollo_samary.desarrollo_samary.Repository.Detalle_PedidoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Detalle_PedidoService {

    private final Detalle_PedidoRepository repository;

    public Detalle_PedidoService(Detalle_PedidoRepository repository) {
        this.repository = repository;
    }

    public List<Detalle_Pedido> obtenerTodos() {
        return repository.findAll();
    }

    public Optional<Detalle_Pedido> obtenerPorId(Integer id) {
        return repository.findById(id);
    }

    public Detalle_Pedido guardar(Detalle_Pedido detalle) {
        return repository.save(detalle);
    }

    public void eliminar(Integer id) {
        repository.deleteById(id);
    }
}
