package com.challenge.backendfinanceiro.dto;

import com.challenge.backendfinanceiro.entities.enums.Categoria;

import java.util.List;

public class CategoriaGastoDTO {

    private Categoria categoria;
    private Double valor;

    public CategoriaGastoDTO() {
    }

    public CategoriaGastoDTO(Categoria categoria, Double valor) {
        this.categoria = categoria;
        this.valor = valor;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }


}
