package br.edu.infnet.raphael_torres.interfaces;

import java.util.List;

public interface IBaseService<TEntity> {

    List<TEntity> list();
    List<TEntity> findByNome(String nome);
    void create(TEntity entity);
} 
