package br.edu.infnet.raphael_torres.model.domain;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Midia {
    private String nome;
    private LocalDate lancamento;
    private float mediaAvaliacao;
    private int vendasPorAno;
}

