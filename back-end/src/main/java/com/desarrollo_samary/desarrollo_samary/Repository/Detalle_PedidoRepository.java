package com.desarrollo_samary.desarrollo_samary.Repository;

import com.desarrollo_samary.desarrollo_samary.Entity.Detalle_Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Detalle_PedidoRepository extends JpaRepository<Detalle_Pedido, Integer> {
}

