package com.desarrollo_samary.desarrollo_samary.Repository;
import com.desarrollo_samary.desarrollo_samary.Entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer> {
}
