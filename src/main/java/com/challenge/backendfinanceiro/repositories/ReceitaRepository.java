package com.challenge.backendfinanceiro.repositories;

import com.challenge.backendfinanceiro.entities.Receita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReceitaRepository extends JpaRepository<Receita, Long> {

    List<Receita> findReceitaByDescricao(String descricao);

    @Query(value = "SELECT * FROM receitas WHERE YEAR(data)=:ano and MONTH(data)=:mes", nativeQuery = true)
    List<Receita> findReceitaByDate(@Param("ano") Integer ano,@Param("mes") Integer mes);

    @Query(value = "SELECT * FROM receitas WHERE YEAR(data)=:ano and MONTH(data)=:mes and descricao=:descricao", nativeQuery = true)
    List<Receita> findReceitaByDateAndDescricao(@Param("ano") Integer ano,@Param("mes") Integer mes,@Param("descricao") String descricao);

    @Query(value = "SELECT SUM(valor) FROM receitas WHERE YEAR(data)=:ano and MONTH(data)=:mes", nativeQuery = true)
    Double findSumValorReceitaByDate(@Param("ano") Integer ano,@Param("mes") Integer mes);



}
