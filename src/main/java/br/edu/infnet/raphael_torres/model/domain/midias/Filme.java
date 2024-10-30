package br.edu.infnet.raphael_torres.model.domain.midias;

import br.edu.infnet.raphael_torres.model.domain.Midia;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "filmes")
public class Filme extends Midia {

     @Column(nullable = false)
    private String diretor;

    @Column(nullable = false)
    private int duracao; // duração em minutos
}
