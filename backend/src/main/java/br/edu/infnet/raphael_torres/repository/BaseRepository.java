package br.edu.infnet.raphael_torres.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;
import java.util.UUID;

@NoRepositoryBean
public interface BaseRepository<INamedModel> extends CrudRepository<INamedModel, UUID> {
     List<INamedModel> findByNomeContainingIgnoreCase(String nome);
}
