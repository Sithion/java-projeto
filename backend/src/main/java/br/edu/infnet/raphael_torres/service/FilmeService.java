package br.edu.infnet.raphael_torres.service;
import org.springframework.stereotype.Service;

import br.edu.infnet.raphael_torres.model.domain.midias.Filme;
import br.edu.infnet.raphael_torres.repository.FilmeRepository;

@Service
public class FilmeService extends BaseService<Filme> {


    public FilmeService(FilmeRepository filmeRepository) {
        super(filmeRepository);
    }

}
