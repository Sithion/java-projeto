package br.edu.infnet.raphael_torres.controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.raphael_torres.model.domain.midias.Filme;
import br.edu.infnet.raphael_torres.service.FilmeService;

@RestController
@RequestMapping("/filme")
public class FilmeController extends BaseController<Filme> {

    public FilmeController(FilmeService filmeService) {
        super(filmeService);
    }

}
