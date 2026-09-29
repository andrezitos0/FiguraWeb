package br.com.figurahistorica.cadastro_figura.controller;

import br.com.figurahistorica.cadastro_figura.business.FiguraService;
import br.com.figurahistorica.cadastro_figura.infrastructure.entities.Figura;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/figura")
@RequiredArgsConstructor

public class FiguraController {

    private final FiguraService figuraService;

    @PostMapping
    public ResponseEntity<Void> salvarFigura(@RequestBody Figura figura){
        FiguraService.salvarFigura(figura);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<Figura> buscarFiguraPorNome(@RequestParam String nome){
        return  ResponseEntity.ok(figuraService.buscarFiguraPorNome(nome));
    }

    @DeleteMapping
    public ResponseEntity<Void> deletarFiguraPorNome(@RequestParam String nome){
        FiguraService.deletarFiguraPorNome(nome);
        return ResponseEntity.ok().build();
    }

}
