package br.edu.infnet.raphael_torres.model.domain.midias;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import br.edu.infnet.raphael_torres.model.domain.Midia;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "filmes")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Filme extends Midia {

    @NotBlank(message = "O nome do diretor é obrigatório.")
    @Size(min = 3, max = 50, message = "O nome do diretor deve ter entre 3 e 50 caracteres.")
    @Column(nullable = false)
    private String diretor;

    @NotNull(message = "A duração é obrigatória.")
    @Column(nullable = false)
    private int duracao ; // duração em minutos
}
