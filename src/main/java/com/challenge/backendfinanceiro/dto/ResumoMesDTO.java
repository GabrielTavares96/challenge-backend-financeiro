package com.challenge.backendfinanceiro.dto;

import java.util.List;

public class ResumoMesDTO {

    private Double totalReceita;
    private Double totalDespesa;
    private Double saldoFinal;
    private List<CategoriaGastoDTO> categoriaGastoDTO;

    public ResumoMesDTO() {
    }

    public ResumoMesDTO(Double totalReceita, Double totalDespesa, Double saldoFinal, List<CategoriaGastoDTO> categoriaGastoDTO) {
        this.totalReceita = totalReceita;
        this.totalDespesa = totalDespesa;
        this.saldoFinal = saldoFinal;
        this.categoriaGastoDTO = categoriaGastoDTO;
    }

    public Double getTotalReceita() {
        return totalReceita;
    }

    public void setTotalReceita(Double totalReceita) {
        this.totalReceita = totalReceita;
    }

    public Double getTotalDespesa() {
        return totalDespesa;
    }

    public void setTotalDespesa(Double totalDespesa) {
        this.totalDespesa = totalDespesa;
    }

    public Double getSaldoFinal() {
        return saldoFinal;
    }

    public void setSaldoFinal(Double saldoFinal) {
        this.saldoFinal = saldoFinal;
    }

    public List<CategoriaGastoDTO> getCategoriaGastoDTO() {
        return categoriaGastoDTO;
    }

    public void setCategoriaGastoDTO(List<CategoriaGastoDTO> categoriaGastoDTO) {
        this.categoriaGastoDTO = categoriaGastoDTO;
    }
}
