package br.edu.infnet.raphael_torres.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import br.edu.infnet.raphael_torres.interfaces.IBaseService;
import br.edu.infnet.raphael_torres.interfaces.INamedModel;
import br.edu.infnet.raphael_torres.repository.BaseRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class BaseService<TModel extends INamedModel> implements IBaseService<TModel> {

    private final BaseRepository<TModel> repository;

    public void createOrUpdate(TModel entidade) {
        repository.save(entidade);
    }

    public void remove(UUID id) {
        Optional<TModel> model = repository.findById(id);
        repository.delete(model.get());
    }

    public List<TModel> findByNome(String nome) {
        return repository.findByNomeContainingIgnoreCase(nome);
    }

    public List<TModel> list() {
        return (ArrayList<TModel>) repository.findAll();
    }

    public TModel findById(UUID id) {
        Optional<TModel> item = repository.findById(id);
        return item.get();
    }

}
