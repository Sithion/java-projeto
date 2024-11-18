package br.edu.infnet.raphael_torres.service;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.raphael_torres.client.CepExternalClient;
import br.edu.infnet.raphael_torres.model.domain.Endereco;
import br.edu.infnet.raphael_torres.model.domain.Espectador;
import br.edu.infnet.raphael_torres.model.domain.Midia;
import br.edu.infnet.raphael_torres.repository.EspectadorRepository;
import br.edu.infnet.raphael_torres.repository.MidiaRepository;
import br.edu.infnet.raphael_torres.repository.EnderecoRepository;

@Service
public class EspectadorService extends BaseService<Espectador> {

      @Autowired
      private EspectadorRepository espectadorRepository;
      @Autowired
      private MidiaRepository midiaRepository;
      @Autowired
      private EnderecoRepository enderecoRepository;

      @Autowired
      private CepExternalClient cepExternalClient;

      public EspectadorService(EspectadorRepository espectadorRepository) {
            super(espectadorRepository);
      }

      @Override
      public void createOrUpdate(Espectador espectador) {            
            if(espectador.getEndereco() != null) {
                  Endereco endereco = cepExternalClient.findByCep(espectador.getEndereco().getCep());
                  Endereco espectadorEndereco = espectador.getEndereco();
                  endereco.setId(espectadorEndereco.getId());
                  endereco.setNumero(espectadorEndereco.getNumero());
                  endereco.setComplemento(espectadorEndereco.getComplemento());
                  enderecoRepository.save(endereco);
                  espectador.setEndereco(endereco);
            }   
            espectadorRepository.save(espectador);
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