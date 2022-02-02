package com.challenge.backendfinanceiro.repositories;

import com.challenge.backendfinanceiro.dto.CategoriaGastoDTO;
import com.challenge.backendfinanceiro.dto.ResumoMesDTO;
import com.challenge.backendfinanceiro.entities.Despesa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DespesaRepository extends JpaRepository<Despesa, Long> {

    List<Despesa> findDespesaByDescricao(String descricao);

    @Query(value = "SELECT * FROM despesas WHERE YEAR(data)=:ano and MONTH(data)=:mes", nativeQuery = true)
    List<Despesa> findDespesaByDate(@Param("ano") Integer ano, @Param("mes") Integer mes);

    @Query(value = "SELECT * FROM despesas WHERE YEAR(data)=:ano and MONTH(data)=:mes and descricao=:descricao", nativeQuery = true)
    List<Despesa> findDespesaByDateAndDescricao(@Param("ano") Integer ano,@Param("mes") Integer mes,@Param("descricao") String descricao);

    @Query(value = "SELECT SUM(valor) FROM despesas WHERE YEAR(data)=:ano and MONTH(data)=:mes", nativeQuery = true)
    Double findSumValorDespesaByDate(@Param("ano") Integer ano,@Param("mes") Integer mes);

    @Query(value = "SELECT new com.challenge.backendfinanceiro.dto.CategoriaGastoDTO(d.categoria, SUM(d.valor)) FROM Despesa d WHERE YEAR(d.data)= ?1 and MONTH(d.data)= ?2 GROUP BY d.categoria")
    List<CategoriaGastoDTO> findValorDespesaByCategoria(Integer ano, Integer mes);

}
