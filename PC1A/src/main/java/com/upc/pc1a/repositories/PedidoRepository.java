package com.upc.pc1a.repositories;

import com.upc.pc1a.entities.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    @Query(value = "SELECT categoria, SUM(precio * cantidad) as total " +
            "FROM pedido GROUP BY categoria", nativeQuery = true)
    List<Object[]> ventasPorCategoriaNative();
}