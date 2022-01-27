package com.challenge.backendfinanceiro.services;

import com.challenge.backendfinanceiro.dto.ReceitaDTO;
import com.challenge.backendfinanceiro.entities.Receita;
import com.challenge.backendfinanceiro.repositories.ReceitaRepository;
import com.challenge.backendfinanceiro.services.exceptions.ResourceNotFoundException;
import com.challenge.backendfinanceiro.util.DataUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ReceitaService {

    @Autowired
    private ReceitaRepository repository;

    @Transactional(readOnly = true)
    public ReceitaDTO findById(Long id) {
        Optional<Receita> receita = repository.findById(id);
        Receita entity = receita.orElseThrow(() -> new ResourceNotFoundException(id));
        return new ReceitaDTO(entity);
    }

    @Transactional(readOnly = true)
    public List<ReceitaDTO> findByDescricao(String descricao) {
        List<Receita> receitas = repository.findReceitaByDescricao(descricao);

        return receitas.stream().map(x -> new ReceitaDTO(x)).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<ReceitaDTO> findByDate(Integer ano, Integer mes) {

        List<Receita> receitas = repository.findReceitaByDate(ano,mes);

        return receitas.stream().map(x -> new ReceitaDTO(x)).collect(Collectors.toList());
    }


    @Transactional(readOnly = true)
    public List<ReceitaDTO> findAll() {
        List<Receita> receitas = repository.findAll();
        return receitas.stream().map(x -> new ReceitaDTO(x)).collect(Collectors.toList());
    }


    @Transactional
    public ReceitaDTO insert(ReceitaDTO dto) throws Exception {
        List<Receita> list = repository.findReceitaByDateAndDescricao(DataUtil.getYear(dto.getData()), DataUtil.getMonth(dto.getData()),dto.getDescricao());

        if (list.isEmpty()) {
            Receita entity = new Receita();

            entity.setId(dto.getId());
            entity.setDescricao(dto.getDescricao());
            entity.setValor(dto.getValor());
            entity.setData(dto.getData());


            entity = repository.save(entity);
            return new ReceitaDTO(entity);
        } else {
            throw new Exception();
        }
    }

    @Transactional
    public ReceitaDTO update(Long id, ReceitaDTO dto) {
        try {
            Receita entity = repository.getById(id);
            entity.setDescricao(dto.getDescricao());
            entity.setValor(dto.getValor());
            entity.setData(dto.getData());

            entity = repository.save(entity);

            return new ReceitaDTO(entity);
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
