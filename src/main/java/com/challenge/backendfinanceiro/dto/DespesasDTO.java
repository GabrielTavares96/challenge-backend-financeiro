package com.challenge.backendfinanceiro.dto;

import com.challenge.backendfinanceiro.entities.Despesa;

import javax.validation.constraints.NotBlank;
import java.util.Date;

public class DespesasDTO {

    private Long id;

    @NotBlank(message = "Campo obrigatório")
    private String descricao;

    @NotBlank(message = "Campo obrigatório")
    private String valor;

    private Date data;

    public DespesasDTO(){

    }

    public DespesasDTO(Despesa entity){
        this.id = entity.getId();
        this.descricao = entity.getDescricao();
        this.valor = entity.getValor();
        this.data = entity.getData();
    }

    public Long getId() {return id;}

    public void setId(Long id) {this.id = id;}

    public String getDescricao() {return descricao;}

    public void setDescricao(String descricao) {this.descricao = descricao;}

    public String getValor() {return valor;}

    public void setValor(String valor) {this.valor = valor;}

    public Date getData() {return data;}

    public void setData(Date data) {this.data = data;}
}
