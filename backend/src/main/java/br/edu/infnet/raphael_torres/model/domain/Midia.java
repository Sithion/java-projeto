package br.edu.infnet.raphael_torres.model.domain;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import br.edu.infnet.raphael_torres.interfaces.INamedModel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name = "midias")
@Inheritance(strategy = InheritanceType.JOINED)
@Entity
public abstract class Midia implements INamedModel {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private LocalDate lancamento;

    @Column(nullable = false)
    private float mediaAvaliacao;

    @Column(nullable = false)
    private int vendasPorAno;
    
    @ManyToMany(mappedBy = "midias", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @JsonManagedReference
    private Set<Espectador> espectadores = new HashSet<Espectador>();
}