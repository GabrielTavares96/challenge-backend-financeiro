package com.challenge.backendfinanceiro.dto;

import com.challenge.backendfinanceiro.entities.Despesa;
import com.challenge.backendfinanceiro.entities.enums.Categoria;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.Date;

public class DespesasDTO {

    private Long id;

    @NotBlank(message = "Campo obrigatório")
    private String descricao;

    @NotBlank(message = "Campo obrigatório")
    private String valor;

    private LocalDate data;

    private Categoria categoria;

    public DespesasDTO() {

    }

    public DespesasDTO(Despesa entity) {
        this.id = entity.getId();
        this.descricao = entity.getDescricao();
        this.valor = entity.getValor();
        this.data = entity.getData();
        this.categoria = entity.getCategoria();

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
