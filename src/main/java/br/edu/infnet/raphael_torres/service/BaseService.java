package br.edu.infnet.raphael_torres.service;

import java.util.ArrayList;
import java.util.List;

import br.edu.infnet.raphael_torres.interfaces.IBaseService;
import br.edu.infnet.raphael_torres.repository.BaseRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class BaseService<INamedModel> implements IBaseService<INamedModel> {

    private final BaseRepository<INamedModel> repository;

    @Override
    public void create(INamedModel entidade) {
        repository.save(entidade);
    }

    public List<INamedModel> findByNome(String nome) {
        return repository.findByNomeContainingIgnoreCase(nome);
    }

    @Override
    public List<INamedModel> list() {
        return (ArrayList<INamedModel>) repository.findAll();
    }

}
