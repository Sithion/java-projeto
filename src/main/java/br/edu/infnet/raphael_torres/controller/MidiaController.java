package br.edu.infnet.raphael_torres.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.raphael_torres.model.domain.Midia;
import br.edu.infnet.raphael_torres.model.domain.midias.Filme;
import br.edu.infnet.raphael_torres.model.domain.midias.Livro;

@RestController
@RequestMapping("/midia")
public class MidiaController {

    @PostMapping("/{midiaTipo}")
    public String criarMidia(@PathVariable String midiaTipo, @RequestBody Midia midia) {
        switch (midiaTipo.toLowerCase()) {
            case "livro":
                if (midia instanceof Livro) {
                    return "Livro recebido: " + midia.toString();
                }
                break;
            case "filme":
                if (midia instanceof Filme) {
                    return "Filme recebido: " + midia.toString();
                }
                break;
            default:
                return "Tipo de mídia não suportado: " + midiaTipo;
        }
        return "Tipo de mídia incompatível com o payload fornecido.";
    }
}