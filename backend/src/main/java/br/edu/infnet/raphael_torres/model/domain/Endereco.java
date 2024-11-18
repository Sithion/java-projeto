package br.edu.infnet.raphael_torres.model.domain;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="enderecos")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Endereco {
	
	@Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
	
    @NotBlank(message = "O campo 'cep' é obrigatório.")
    @Column(nullable = false)
	private String cep;

    @NotBlank(message = "O campo 'logradouro' é obrigatório.")
    @Size(max = 100, message = "O campo 'logradouro' não pode ter mais de 100 caracteres.")
    private String logradouro;

    @NotBlank(message = "O campo 'cidade' é obrigatório.")
    @Size(max = 50, message = "O campo 'cidade' não pode ter mais de 50 caracteres.")
    private String cidade;

    @NotBlank(message = "O campo 'uf' é obrigatório.")
    @Size(min = 2, max = 2, message = "O campo 'uf' deve ter exatamente 2 caracteres.")
    private String uf;

    @NotNull(message = "O campo 'numero' é obrigatório.")
    private Integer numero;

    @Size(max = 20, message = "O campo 'complemento' não pode ter mais de 20 caracteres.")
    private String complemento;
}