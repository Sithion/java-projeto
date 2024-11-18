package br.edu.infnet.raphael_torres.model.domain;

import org.hibernate.annotations.DynamicUpdate;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="enderecos")
@DynamicUpdate
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Endereco extends BaseModel {
	
    private String cep;

    private String logradouro;

    private String localidade;

    private String uf;
    
    private Integer numero;

    private String complemento;
}