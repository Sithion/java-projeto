package br.edu.infnet.raphael_torres.interfaces;

import java.util.List;

public interface IBaseService<TEntity> {

    List<TEntity> list();
    List<TEntity> findByNome(String nome);
    TEntity findById(String id);
    void create(TEntity entity);
} 
