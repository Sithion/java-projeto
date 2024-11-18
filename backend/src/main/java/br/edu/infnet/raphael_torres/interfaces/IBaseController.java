package br.edu.infnet.raphael_torres.interfaces;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

public interface IBaseController<TEntity> {
    public ResponseEntity<Void> create(TEntity entidade);
    public ResponseEntity<Void> update(TEntity entidade);
    public List<TEntity> list(@RequestParam(name = "nome", required = false) String nome);
    public TEntity findById(String id);
}
