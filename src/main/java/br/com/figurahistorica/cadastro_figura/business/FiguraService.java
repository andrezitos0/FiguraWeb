package br.com.figurahistorica.cadastro_figura.business;

import br.com.figurahistorica.cadastro_figura.infrastructure.entities.Figura;
import br.com.figurahistorica.cadastro_figura.infrastructure.repository.FiguraRepository;
import org.springframework.stereotype.Service;

public class FiguraService {

    private final FiguraRepository repository;

    public FiguraRepository(FiguraRepository repository){
        this.repository = repository;
    }

    public void salvarFigura(Figura figura){
        repository.saveAndFlush(figura);
    }

    public Figura buscarFiguraPorNome(String nome){
        return repository.findByNome(nome).orElseThrow(
                () -> new RuntimeException("Nome nao encontrado")
        );
    }


}
