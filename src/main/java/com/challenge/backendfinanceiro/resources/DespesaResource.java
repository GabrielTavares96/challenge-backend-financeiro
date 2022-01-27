package com.challenge.backendfinanceiro.resources;


import com.challenge.backendfinanceiro.dto.DespesasDTO;
import com.challenge.backendfinanceiro.services.DespesaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/despesas")
public class DespesaResource {

    @Autowired
    private DespesaService service;

    @GetMapping
    public ResponseEntity<List<DespesasDTO>> findAll() {
        List<DespesasDTO> despesas = service.findAll();
        return ResponseEntity.ok(despesas);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<DespesasDTO> findById(@PathVariable Long id) {
        DespesasDTO dto = service.findById(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping(value = "/search")
    public ResponseEntity<List<DespesasDTO>> findByDescricao(
            @RequestParam(value = "descricao", required = true) String descricao

    ) {
        List<DespesasDTO> despesas = service.findByDescricao(descricao);
        return ResponseEntity.ok(despesas);
    }

    @GetMapping(value = "/{ano}/{mes}")
        public ResponseEntity<List<DespesasDTO>> findByData(@PathVariable Integer ano, @PathVariable Integer mes){
        List<DespesasDTO> despesas = service.findByDate(ano, mes);
        return ResponseEntity.ok(despesas);
    }
    @PostMapping
    public ResponseEntity<DespesasDTO> insert(@RequestBody @Valid DespesasDTO dto) throws Exception {
        dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<DespesasDTO> update(@PathVariable Long id, @Valid @RequestBody DespesasDTO dto) {
        dto = service.update(id, dto);
        return ResponseEntity.ok(dto);
    }


    @DeleteMapping(value = "/{id}")
    public ResponseEntity<DespesasDTO> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
