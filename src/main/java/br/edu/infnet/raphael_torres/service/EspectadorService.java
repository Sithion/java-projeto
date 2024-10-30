package br.edu.infnet.raphael_torres.service;

import java.util.ArrayList;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.raphael_torres.model.domain.Espectador;
import br.edu.infnet.raphael_torres.repository.EspectadorRepository;
import br.edu.infnet.raphael_torres.repository.MidiaRepository;

@Service
public class EspectadorService extends BaseService<Espectador> {

      @Autowired
      private EspectadorRepository espectadorRepository;
      @Autowired
      private MidiaRepository midiaRepository;

      public EspectadorService(EspectadorRepository espectadorRepository) {
            super(espectadorRepository);
      }

      @Override
      public void create(Espectador espectador) {
            midiaRepository.saveAll(espectador.getMidias());
            espectadorRepository.save(espectador);
      }
}