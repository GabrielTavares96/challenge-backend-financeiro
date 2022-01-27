package com.challenge.backendfinanceiro.services;

import com.challenge.backendfinanceiro.dto.DespesasDTO;
import com.challenge.backendfinanceiro.dto.ReceitaDTO;
import com.challenge.backendfinanceiro.entities.Despesa;
import com.challenge.backendfinanceiro.entities.enums.Categoria;
import com.challenge.backendfinanceiro.repositories.DespesaRepository;
import com.challenge.backendfinanceiro.services.exceptions.ResourceNotFoundException;
import com.challenge.backendfinanceiro.util.DataUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DespesaService {

    @Autowired
    private DespesaRepository repository;

    @Transactional(readOnly = true)
    public List<DespesasDTO> findAll() {
        List<Despesa> despesas = repository.findAll();
        return despesas.stream().map(x -> new DespesasDTO(x)).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public DespesasDTO findById(Long id) {
        Optional<Despesa> despesa = repository.findById(id);
        Despesa entity = despesa.orElseThrow(() -> new ResourceNotFoundException(id));
        return new DespesasDTO(entity);
    }

    @Transactional(readOnly = true)
    public List<DespesasDTO> findByDescricao(String descricao) {
        List<Despesa> despesas = repository.findDespesaByDescricao(descricao);

        return despesas.stream().map(x -> new DespesasDTO(x)).collect(Collectors.toList());
    }

    @Transactional
    public List<DespesasDTO> findByDate (Integer ano, Integer mes){

        List<Despesa> despesas = repository.findDespesaByDate(ano,mes);

        return despesas.stream().map(x -> new DespesasDTO(x)).collect(Collectors.toList());
    }

    @Transactional
    public DespesasDTO insert(DespesasDTO dto) throws Exception {
        List<Despesa> list = repository.findDespesaByDateAndDescricao(DataUtil.getYear(dto.getData()), DataUtil.getMonth(dto.getData()),dto.getDescricao());

        if (list.isEmpty()) {
            Despesa entity = new Despesa();

            entity.setId(dto.getId());
            entity.setDescricao(dto.getDescricao());
            entity.setValor(dto.getValor());
            entity.setData(dto.getData());

            if (dto.getCategoria() == null) {
                entity.setCategoria(Categoria.OUTRAS);
            } else {
                entity.setCategoria(dto.getCategoria());
            }

            entity = repository.save(entity);
            return new DespesasDTO(entity);
        } else {
            throw new Exception();
        }
    }

    @Transactional
    public DespesasDTO update(Long id, DespesasDTO dto) {
        try {
            Despesa entity = repository.getById(id);
            entity.setDescricao(dto.getDescricao());
            entity.setValor(dto.getValor());
            entity.setData(dto.getData());


            entity.setCategoria(dto.getCategoria());

            entity = repository.save(entity);

            return new DespesasDTO(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Id not found " + id);
        }
    }

    public void delete(Long id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        }
    }

}
