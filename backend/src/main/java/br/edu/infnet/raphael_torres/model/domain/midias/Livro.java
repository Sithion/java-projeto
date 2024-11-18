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
@Table(name = "livros")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Livro extends Midia {
    
    @NotBlank(message = "O nome do autor é obrigatório.")
    @Size(min = 3, max = 50, message = "O nome do autor deve ter entre 3 e 50 caracteres.")
    @Column(nullable = false)
    private String autor;

    @NotNull(message = "O número de páginas é obrigatório.")
    @Column(nullable = false)
    private int paginas;
}
