package br.edu.infnet.raphael_torres.model.domain;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import org.hibernate.annotations.DynamicUpdate;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import br.edu.infnet.raphael_torres.interfaces.INamedModel;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name = "midias")
@Inheritance(strategy = InheritanceType.JOINED)
@Entity
@DynamicUpdate
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Midia extends BaseModel implements INamedModel {

    @NotBlank(message = "O nome da mídia é obrigatório.")
    @Size(min = 3, max = 50, message = "O nome da mídia deve ter entre 3 e 50 caracteres.")
    @Column(nullable = false)
    private String nome;

    @Column()
    private float mediaAvaliacao;

    @Column()
    private int vendasPorAno;
    
    @ManyToMany(mappedBy = "midias", fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
    @JsonBackReference
    private Set<Espectador> espectadores = new HashSet<Espectador>();
}
