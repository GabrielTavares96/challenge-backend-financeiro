package com.challenge.backendfinanceiro.entities;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "receitas")
public class Receita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    private String descricao;
    private String valor;
    private Date data;

    public Receita() {
    }

    public Receita(Long id, String descricao, String valor, Date data) {
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

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
}
