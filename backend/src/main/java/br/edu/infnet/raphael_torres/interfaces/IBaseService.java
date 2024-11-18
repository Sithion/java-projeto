package br.edu.infnet.raphael_torres.interfaces;

import java.util.List;
import java.util.UUID;

public interface IBaseService<TEntity> {

    List<TEntity> list();
    List<TEntity> findByNome(String nome);
    TEntity findById(UUID id);
    void createOrUpdate(TEntity entity);
    void remove(UUID id);
} 
