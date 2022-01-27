package com.challenge.backendfinanceiro.resources;

import com.challenge.backendfinanceiro.dto.ReceitaDTO;
import com.challenge.backendfinanceiro.services.ReceitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/receitas")
public class ReceitaResource {

    @Autowired
    private ReceitaService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<ReceitaDTO> findById(@PathVariable Long id) {
        ReceitaDTO dto = service.findById(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping(value = "/{ano}/{mes}")
    public ResponseEntity<List<ReceitaDTO>> findByData(@PathVariable Integer ano, @PathVariable Integer mes) {
        List<ReceitaDTO> receitas = service.findByDate(ano, mes);
        return ResponseEntity.ok(receitas);
    }

    @GetMapping(value = "/search")
    public ResponseEntity<List<ReceitaDTO>> findByDescricao(
            @RequestParam(value = "descricao", required = true) String descricao

    ) {
        List<ReceitaDTO> receitas = service.findByDescricao(descricao);
        return ResponseEntity.ok(receitas);
    }



    @GetMapping
    public ResponseEntity<List<ReceitaDTO>> findAll() {
        List<ReceitaDTO> receitas = service.findAll();
        return ResponseEntity.ok(receitas);
    }



    @PostMapping
    public ResponseEntity<ReceitaDTO> insert(@RequestBody @Valid ReceitaDTO dto) throws Exception {
        dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ReceitaDTO> update(@PathVariable Long id, @Valid @RequestBody ReceitaDTO dto) {
        dto = service.update(id, dto);
        return ResponseEntity.ok(dto);
    }


    @DeleteMapping(value = "/{id}")
    public ResponseEntity<ReceitaDTO> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
