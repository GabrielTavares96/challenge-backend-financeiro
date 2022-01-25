package com.challenge.backendfinanceiro.entities;

import javax.persistence.*;

@Entity
@Table(name = "despesas")
public class Despesa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descricao;
    private String valor;
    private String data;

    public Despesa() {
    }

    public Despesa(Long id, String descricao, String valor, String data) {
        this.id = id;
        this.descricao = descricao;
        this.valor = valor;
        this.data = data;
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

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
