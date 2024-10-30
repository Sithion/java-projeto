package br.edu.infnet.raphael_torres.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.raphael_torres.interfaces.IBaseController;
import br.edu.infnet.raphael_torres.interfaces.IBaseService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public abstract class BaseController<TEntity> implements IBaseController<TEntity> {

    private final IBaseService<TEntity> service;

    @Override
    @GetMapping
    public List<TEntity> list(@RequestParam(name = "nome", required = false) String nome) {
        return nome == null ? service.list() : service.findByNome(nome);
    }

    @Override
    @PostMapping
    public ResponseEntity<Void> create(@RequestBody TEntity entity) {
        service.create(entity);
        return ResponseEntity.ok().build();
    }
}
