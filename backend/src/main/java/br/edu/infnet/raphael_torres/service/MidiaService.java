package br.edu.infnet.raphael_torres.service;

import org.springframework.stereotype.Service;

import br.edu.infnet.raphael_torres.model.domain.Midia;
import br.edu.infnet.raphael_torres.repository.MidiaRepository;

@Service
public class MidiaService extends BaseService<Midia> {


    public MidiaService(MidiaRepository midiaRepository) {
        super(midiaRepository);
    }

}
