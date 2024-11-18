package br.edu.infnet.raphael_torres.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.raphael_torres.Utils;
import br.edu.infnet.raphael_torres.interfaces.IBaseController;
import br.edu.infnet.raphael_torres.interfaces.IBaseService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public abstract class BaseController<TEntity> implements IBaseController<TEntity> {

    protected final IBaseService<TEntity> service;

    @GetMapping
    @Operation(summary = "Lista ou busca através do nome")
    public List<TEntity> list(@RequestParam(name = "nome", required = false) String nome) {
        System.out.println("LISTANDO");
        return nome == null ? service.list() : service.findByNome(nome);
    }

    @Operation(summary = "Busca através do ID.")
    @GetMapping(value = "/{id}")
    public TEntity findById(@PathVariable String id) {
        return service.findById(UUID.fromString(id));
    }

    @Operation(summary = "Cria novo")
    @PostMapping("/")
    public ResponseEntity<Void> create(@Valid @RequestBody TEntity entity) {
        System.out.println("Item recebido: " + entity);
        service.createOrUpdate(entity);
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Atualiza")
    @PutMapping("/")
    public ResponseEntity<Void> update(@Valid @RequestBody TEntity entity) {
        System.out.println("Item recebido: " + entity);
        service.createOrUpdate(entity);
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Remove")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        service.remove(UUID.fromString(id));
        return ResponseEntity.ok().build();
    }
}
