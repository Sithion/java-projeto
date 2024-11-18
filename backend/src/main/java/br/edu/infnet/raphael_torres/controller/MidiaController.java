package br.edu.infnet.raphael_torres.controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.raphael_torres.model.domain.Midia;
import br.edu.infnet.raphael_torres.service.MidiaService;

@RestController
@RequestMapping("/midia")
public class MidiaController extends BaseController<Midia> {

    public MidiaController(MidiaService midiaService) {
        super(midiaService);
    }
}
