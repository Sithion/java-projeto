package br.edu.infnet.raphael_torres.model.domain;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Usuario {
    private String nome;
    private String email;
    private List<Midia> midias = new ArrayList<Midia>();
}
