package br.edu.infnet.raphael_torres.controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.raphael_torres.model.domain.midias.Livro;
import br.edu.infnet.raphael_torres.service.LivroService;

@RestController
@RequestMapping("/livro")
public class LivroController extends BaseController<Livro> {

    public LivroController(LivroService livroService) {
        super(livroService);
    }

}
