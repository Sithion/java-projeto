package br.edu.infnet.raphael_torres.model.domain;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="enderecos")
public class Endereco {
	
	@Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
	
    @Column(nullable = false)
	private String cep;

    @Column(nullable = false)
	private String logradouro;

	private String complemento;

    @Column(nullable = false)
	private String bairro;

    @Column(nullable = false)
	private String localidade;
    
    @Column(nullable = false)
	private String uf;
}