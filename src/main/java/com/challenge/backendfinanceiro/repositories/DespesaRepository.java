package com.challenge.backendfinanceiro.repositories;

import com.challenge.backendfinanceiro.entities.Despesa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DespesaRepository extends JpaRepository<Despesa, Long> {

    List<Despesa> findDespesaByDescricao(String descricao);

}
