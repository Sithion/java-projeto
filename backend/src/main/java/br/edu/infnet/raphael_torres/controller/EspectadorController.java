package br.edu.infnet.raphael_torres.controller;

import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.raphael_torres.model.domain.Espectador;
import br.edu.infnet.raphael_torres.service.EspectadorService;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/espectador")
public class EspectadorController extends BaseController<Espectador>{

    public EspectadorController(EspectadorService espectadorService) {
        super(espectadorService);
    }

    @Operation(summary = "Adicionar midia para o coleção do espectador")
    @PostMapping("/{espectadorId}/midia/{midiaId}")
    public ResponseEntity<Void> adicionaMidia(@PathVariable String espectadorId, @PathVariable String midiaId ) {
        ((EspectadorService)service).adicionarMidia(UUID.fromString(espectadorId), UUID.fromString(midiaId));
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Remover midia da coleção do espectador")
    @DeleteMapping("/{espectadorId}/midia/{midiaId}")
    public ResponseEntity<Void> removerMidia(@PathVariable String espectadorId, @PathVariable String midiaId ) {
        ((EspectadorService)service).removerMidia(UUID.fromString(espectadorId), UUID.fromString(midiaId));
        return ResponseEntity.ok().build();
    }
    
}
