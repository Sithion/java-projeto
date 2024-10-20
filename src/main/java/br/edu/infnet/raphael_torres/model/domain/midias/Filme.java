package br.edu.infnet.raphael_torres.model.domain.midias;

import br.edu.infnet.raphael_torres.model.domain.Midia;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Filme extends Midia {
    private String diretor;
    private int duracao; // duração em minutos
}
