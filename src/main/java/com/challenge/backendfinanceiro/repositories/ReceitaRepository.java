package com.challenge.backendfinanceiro.repositories;

import com.challenge.backendfinanceiro.entities.Receita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReceitaRepository extends JpaRepository<Receita, Long> {

    List<Receita> findReceitaByDescricao(String descricao);
}
