package br.edu.infnet.raphael_torres.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.raphael_torres.model.domain.Espectador;
import br.edu.infnet.raphael_torres.service.EspectadorService;

@RestController
@RequestMapping("/espectador")
public class EspectadorController extends BaseController<Espectador>{

    public EspectadorController(EspectadorService espectadorService) {
        super(espectadorService);
    }
    
}
