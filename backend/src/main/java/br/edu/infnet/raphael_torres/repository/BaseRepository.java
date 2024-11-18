package br.edu.infnet.raphael_torres.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;
import java.util.UUID;
import org.springframework.data.domain.Sort;

@NoRepositoryBean
public interface BaseRepository<TModel> extends CrudRepository<TModel, UUID> {
     Iterable<TModel> findAll(Sort by);
     List<TModel> findByNomeContainingIgnoreCase(String nome);
}
