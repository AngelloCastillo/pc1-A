package com.upc.pc1a.dtos;

public class VentasCategoriaDTO {

    private String categoria;
    private Double totalVentas;

    public VentasCategoriaDTO(String categoria, Double totalVentas) {
        this.categoria = categoria;
        this.totalVentas = totalVentas;
    }

    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }

    public Double getTotalVentas() { return totalVentas; }
    public void setTotalVentas(Double totalVentas) { this.totalVentas = totalVentas; }
}