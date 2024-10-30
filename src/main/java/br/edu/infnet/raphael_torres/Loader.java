package br.edu.infnet.raphael_torres;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.raphael_torres.model.domain.Midia;
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


@Component
public class Loader implements ApplicationRunner {

    @Autowired
    private EspectadorService espectadorService;

    @Autowired
    private MidiaService midiaService;

    private LocalDate convertDate(String value) {
        String[] values = value.split("-");
        return LocalDate.of(Integer.parseInt(values[0]), Integer.parseInt(values[1]), Integer.parseInt(values[2]));
    }

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
                    filme.setNome(campos[1]);
                    filme.setLancamento(convertDate(campos[2]));
                    filme.setMediaAvaliacao(Float.parseFloat(campos[3]));
                    filme.setVendasPorAno(Integer.parseInt(campos[4]));
                    filme.setDiretor(campos[5]);
                    filme.setDuracao(Integer.parseInt(campos[6]));
                    midiaService.create(filme);
                    midias.add(filme);
                    break;
                }
                case "L": {// Livro
                    Livro livro = new Livro();
                    livro.setNome(campos[1]);
                    livro.setLancamento(convertDate(campos[2]));
                    livro.setMediaAvaliacao(Float.parseFloat(campos[3]));
                    livro.setVendasPorAno(Integer.parseInt(campos[4]));
                    livro.setAutor(campos[5]);
                    livro.setPaginas(Integer.parseInt(campos[6]));
                    midiaService.create(livro);
                    midias.add(livro);
                    break;
                }
                case "U": {// Usuário
                    Espectador espectador = new Espectador();
                    espectador.setNome(campos[1]);
                    espectador.setEmail(campos[2]);
                    espectadores.add(espectador);
                    break;
                }
                case "MU": // EspectadorXMidia
                    String espectadorId = campos[1];
                    String midiaId = campos[2];

                    Espectador espectador = espectadores.stream()
                            .filter(u -> u.getEmail().equals(espectadorId))
                            .findFirst()
                            .orElse(null);
                    Midia midia = midias.stream()
                            .filter(m -> m.getNome().equals(midiaId))
                            .findFirst()
                            .orElse(null);
                    if (espectador != null && midia != null) {
                        var midiasEspectador = espectador.getMidias();

                        midiasEspectador.add(midia);
                        espectador.setMidias(midiasEspectador);
                    }

                    break;
                default:

                    break;
            }
            linha = leitura.readLine();
        }
        for (Espectador espectador : espectadores) {
            espectadorService.create(espectador);            
        }
        leitura.close();
    }

}
