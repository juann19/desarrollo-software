package com.desarrollo_samary.desarrollo_samary.Service;
import com.desarrollo_samary.desarrollo_samary.Entity.Pedido;
import com.desarrollo_samary.desarrollo_samary.Repository.PedidoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {

    private final PedidoRepository repository;

    public PedidoService(PedidoRepository repository) {
        this.repository = repository;
    }

    public List<Pedido> obtenerTodos() {
        return repository.findAll();
    }

    public Optional<Pedido> obtenerPorId(Integer id) {
        return repository.findById(id);
    }

    public Pedido guardar(Pedido pedido) {
        return repository.save(pedido);
    }

    public void eliminar(Integer id) {
        repository.deleteById(id);
    }
}

