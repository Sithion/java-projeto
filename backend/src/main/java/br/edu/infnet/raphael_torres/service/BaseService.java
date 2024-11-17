package br.edu.infnet.raphael_torres.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import br.edu.infnet.raphael_torres.Utils;
import br.edu.infnet.raphael_torres.interfaces.IBaseService;
import br.edu.infnet.raphael_torres.interfaces.INamedModel;
import br.edu.infnet.raphael_torres.repository.BaseRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class BaseService<INamedModel> implements IBaseService<INamedModel> {

    private final BaseRepository<INamedModel> repository;

    public void create(INamedModel entidade) {
        repository.save(entidade);
    }

    public List<INamedModel> findByNome(String nome) {
        return repository.findByNomeContainingIgnoreCase(nome);
    }

    public List<INamedModel> list() {
        return (ArrayList<INamedModel>) repository.findAll();
    }

    public INamedModel findById(String id) {
        boolean vaidUUID = Utils.isValidUUID(id);
        Optional<INamedModel> item = vaidUUID ? repository.findById(UUID.fromString(id)) : null;
        if(item == null) {
            throw new Error("Entidade não encontrada");
        }
        return (INamedModel) item;
    }

}
