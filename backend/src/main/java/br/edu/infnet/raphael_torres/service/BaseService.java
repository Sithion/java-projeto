package br.edu.infnet.raphael_torres.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import br.edu.infnet.raphael_torres.interfaces.IBaseService;
import br.edu.infnet.raphael_torres.interfaces.INamedModel;
import br.edu.infnet.raphael_torres.repository.BaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

@RequiredArgsConstructor
public abstract class BaseService<TModel extends INamedModel> implements IBaseService<TModel> {

    private final BaseRepository<TModel> repository;

    public void createOrUpdate(TModel entidade) {
        repository.save(entidade);
    }

    public void remove(UUID id) {
        repository.deleteById(id);
    }

    public List<TModel> findByNome(String nome) {
        return repository.findByNomeContainingIgnoreCase(nome);
    }

    public List<TModel> list() {
        return (ArrayList<TModel>) repository.findAll(Sort.by(Sort.Order.asc("nome")));
    }

    public TModel findById(UUID id) {
        Optional<TModel> item = repository.findById(id);
        if(item.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Recurso não encontrado para o ID: " + id);
        }
        return item.get();
    }

}
