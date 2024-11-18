package br.edu.infnet.raphael_torres.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.edu.infnet.raphael_torres.model.domain.Endereco;

@FeignClient(url = "https://viacep.com.br/ws", name = "cepExternalClient")
public interface CepExternalClient {

	@GetMapping("/{cep}/json/")
	Endereco findByCep(@PathVariable String cep);
}