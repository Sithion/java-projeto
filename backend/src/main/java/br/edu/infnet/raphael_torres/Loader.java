package br.edu.infnet.raphael_torres;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.raphael_torres.model.domain.Midia;
import br.edu.infnet.raphael_torres.model.domain.Endereco;
import br.edu.infnet.raphael_torres.model.domain.Espectador;
import br.edu.infnet.raphael_torres.model.domain.midias.Filme;
import br.edu.infnet.raphael_torres.model.domain.midias.Livro;
import br.edu.infnet.raphael_torres.service.EspectadorService;
import br.edu.infnet.raphael_torres.service.MidiaService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class Loader implements ApplicationRunner {

    @Autowired
    private EspectadorService espectadorService;

    @Autowired
    private MidiaService midiaService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        FileReader file = new FileReader("files/dataset.csv");
        BufferedReader leitura = new BufferedReader(file);

        String linha = leitura.readLine();
        List<Espectador> espectadores = new ArrayList<Espectador>();
        List<Midia> midias = new ArrayList<Midia>();
        while (linha != null) {
            String[] campos = linha.split(";");
            switch (campos[0].toUpperCase()) {
                case "F": {// Filme {
                    Filme filme = new Filme();
                    filme.setId(UUID.fromString(campos[1]));
                    filme.setNome(campos[2]);
                    filme.setMediaAvaliacao(Float.parseFloat(campos[4]));
                    filme.setVendasPorAno(Integer.parseInt(campos[5]));
                    filme.setDiretor(campos[6]);
                    filme.setDuracao(Integer.parseInt(campos[7]));
                    midiaService.createOrUpdate(filme);
                    midias.add(filme);
                    break;
                }
                case "L": {// Livro
                    Livro livro = new Livro();
                    livro.setId(UUID.fromString(campos[1]));
                    livro.setNome(campos[2]);
                    livro.setMediaAvaliacao(Float.parseFloat(campos[4]));
                    livro.setVendasPorAno(Integer.parseInt(campos[5]));
                    livro.setAutor(campos[6]);
                    livro.setPaginas(Integer.parseInt(campos[7]));
                    midiaService.createOrUpdate(livro);
                    midias.add(livro);
                    break;
                }
                case "U": {// Espectador
                    Espectador espectador = new Espectador();
                    espectador.setId(UUID.fromString(campos[1]));
                    espectador.setNome(campos[2]);
                    espectador.setEmail(campos[3]);
                    if (campos.length == 5) {
                        Endereco endereco = new Endereco();
                        endereco.setCep(campos[4]);
                        espectador.setEndereco(endereco);
                    }
                    espectadorService.createOrUpdate(espectador);
                    espectadores.add(espectador);
                    break;
                }
                case "MU": // EspectadorXMidia
                    String espectadorId = campos[1];
                    String midiaId = campos[2];
                    Espectador espectador = espectadorService.findById(UUID.fromString(espectadorId));
                    Midia midia = midiaService.findById(UUID.fromString(midiaId));
                    if (espectador != null && midia != null) {
                        var midiasEspectador = espectador.getMidias();
                        midiasEspectador.add(midia);
                        espectador.setMidias(midiasEspectador);
                        espectadorService.createOrUpdate(espectador);
                    }

                    break;
                default:

                    break;
            }
            linha = leitura.readLine();
        }
        leitura.close();
    }

}
