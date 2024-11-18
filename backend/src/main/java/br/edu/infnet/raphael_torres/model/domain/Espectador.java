package br.edu.infnet.raphael_torres.model.domain;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import org.hibernate.annotations.DynamicUpdate;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import br.edu.infnet.raphael_torres.interfaces.INamedModel;
import jakarta.persistence.JoinTable;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="espectadores")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@DynamicUpdate
public class Espectador extends BaseModel implements INamedModel {


    @NotBlank(message = "O nome do espectador é obrigatório.")
	@Size(min = 3, max = 50, message = "O nome do espectador deve ter entre 3 e 50 caracteres.")
    @Column(nullable = false)
    private String nome;
    
    @NotBlank(message = "O email do espectador é obrigatório.")
	@Email(message = "O email do espectador informado é inválido")
    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private boolean ativo = false;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
    @JoinTable(
        name = "espectador_midias",
        joinColumns = @JoinColumn(name = "espectador_id"),
        inverseJoinColumns = @JoinColumn(name = "midia_id")
    )
    private Set<Midia> midias = new HashSet<Midia>();

    @OneToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(name = "idEndereco")
    private Endereco endereco;

}
