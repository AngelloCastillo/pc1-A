package com.upc.pc1a.services;

import com.upc.pc1a.dtos.PedidoRequestDTO;
import com.upc.pc1a.dtos.VentasCategoriaDTO;
import com.upc.pc1a.entities.Cliente;
import com.upc.pc1a.entities.Pedido;
import com.upc.pc1a.repositories.ClienteRepository;
import com.upc.pc1a.repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
@Service
public class PedidoService {

    @Autowired
    private PedidoRepository e2_pedidoRepository;

    @Autowired
    private ClienteRepository e2_clienteRepository;

    public Pedido registrarPedido(PedidoRequestDTO e2_dto) {
        Cliente e2_cliente = e2_clienteRepository.findById(e2_dto.getClienteId())
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));

        Pedido e2_pedido = new Pedido();
        e2_pedido.setCodigoPedido(UUID.randomUUID().toString());
        e2_pedido.setProducto(e2_dto.getProducto());
        e2_pedido.setCategoria(e2_dto.getCategoria());
        e2_pedido.setCantidad(e2_dto.getCantidad());
        e2_pedido.setPrecio(e2_dto.getPrecio());
        e2_pedido.setFecha(LocalDate.now());
        e2_pedido.setEstado(true);
        e2_pedido.setCliente(e2_cliente);

        return e2_pedidoRepository.save(e2_pedido);
    }

    public List<VentasCategoriaDTO> obtenerVentasPorCategoria() {
        List<Object[]> e2_resultados = e2_pedidoRepository.ventasPorCategoriaNative();
        List<VentasCategoriaDTO> e2_lista = new ArrayList<>();

        for (Object[] fila : e2_resultados) {
            e2_lista.add(new VentasCategoriaDTO((String) fila[0], ((Number) fila[1]).doubleValue()));
        }

        return e2_lista;
    }
}