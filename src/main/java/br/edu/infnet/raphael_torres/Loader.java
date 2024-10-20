package br.edu.infnet.raphael_torres;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.raphael_torres.model.domain.Midia;
import br.edu.infnet.raphael_torres.model.domain.Usuario;
import br.edu.infnet.raphael_torres.model.domain.midias.Filme;
import br.edu.infnet.raphael_torres.model.domain.midias.Livro;
import br.edu.infnet.raphael_torres.service.UsuarioService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Component
public class Loader implements ApplicationRunner {

    @Autowired
    private UsuarioService usuarioService;

    private LocalDate convertDate(String value) {
        String[] values = value.split("-");
        return LocalDate.of(Integer.parseInt(values[0]), Integer.parseInt(values[1]), Integer.parseInt(values[2]));
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        FileReader file = new FileReader("files/dataset.csv");
        BufferedReader leitura = new BufferedReader(file);

        String linha = leitura.readLine();
        List<Usuario> usuarios = new ArrayList<Usuario>();
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

                    midias.add(livro);
                    break;
                }
                case "U": {// Usuário
                    Usuario usuario = new Usuario();
                    usuario.setNome(campos[1]);
                    usuario.setEmail(campos[2]);
                    usuarios.add(usuario);
                    break;
                }
                case "MU": // Usuário
                    String usuarioId = campos[1];
                    String mediaId = campos[2];

                    Usuario usuario = usuarios.stream()
                            .filter(u -> u.getEmail().equals(usuarioId))
                            .findFirst()
                            .orElse(null);
                    Midia midia = midias.stream()
                            .filter(m -> m.getNome().equals(mediaId))
                            .findFirst()
                            .orElse(null);
                    if (usuario != null && midia != null) {
                        List<Midia> midiasUsuario = usuario.getMidias();

                        midiasUsuario.add(midia);
                        usuario.setMidias(midiasUsuario);
                    }

                    break;
                default:

                    break;
            }
            linha = leitura.readLine();
        }
        for (Usuario usuario : usuarios) {
            usuarioService.add(usuario);            
        }
        leitura.close();
    }

}
