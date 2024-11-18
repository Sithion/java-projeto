package br.edu.infnet.raphael_torres.service;
import org.springframework.stereotype.Service;

import br.edu.infnet.raphael_torres.model.domain.midias.Livro;
import br.edu.infnet.raphael_torres.repository.LivroRepository;

@Service
public class LivroService extends BaseService<Livro> {

    public LivroService(LivroRepository livroRepository) {
        super(livroRepository);
    }

}
