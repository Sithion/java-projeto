package br.edu.infnet.raphael_torres.repository;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.raphael_torres.model.domain.Endereco;


@Repository
public interface EnderecoRepository extends CrudRepository<Endereco, UUID> {
    
}
