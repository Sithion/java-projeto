package br.edu.infnet.raphael_torres.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.raphael_torres.model.domain.Espectador;
import br.edu.infnet.raphael_torres.model.domain.Midia;
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

      public void adicionarMidia(UUID espectadorId, UUID midiaId) {
            Optional<Espectador> espectador = espectadorRepository.findById(espectadorId);
            Optional<Midia> midia = midiaRepository.findById(midiaId);
            Set<Midia> midiasDoEspectador = espectador.get().getMidias();
            midiasDoEspectador.add(midia.get());
            espectador.get().setMidias(midiasDoEspectador);
            espectadorRepository.save(espectador.get());
           
      }
      public void removerMidia(UUID espectadorId, UUID midiaId) {
            Optional<Espectador> espectador = espectadorRepository.findById(espectadorId);
            Optional<Midia> midia = midiaRepository.findById(midiaId);
            Set<Midia> midiasDoEspectador = espectador.get().getMidias();
            midiasDoEspectador.remove(midia.get());
            espectador.get().setMidias(midiasDoEspectador);
            espectadorRepository.save(espectador.get());
           
      }

      
}