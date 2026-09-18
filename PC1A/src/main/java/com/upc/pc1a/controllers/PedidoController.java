package com.upc.pc1a.controllers;

import com.upc.pc1a.dtos.PedidoRequestDTO;
import com.upc.pc1a.dtos.VentasCategoriaDTO;
import com.upc.pc1a.entities.Pedido;
import com.upc.pc1a.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pedido")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @PostMapping("/registrar")
    public ResponseEntity<Pedido> registrar(@RequestBody PedidoRequestDTO dto) {
        return ResponseEntity.ok(pedidoService.registrarPedido(dto));
    }

    @GetMapping("/ventasCategoria")
    public ResponseEntity<List<VentasCategoriaDTO>> ventasCategoria() {
        return ResponseEntity.ok(pedidoService.obtenerVentasPorCategoria());
    }
}