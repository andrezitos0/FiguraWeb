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

    public void atualizarFiguraPorId(Integer id, Figura figura){
        Figura figuraEntity = repository.findById(id).orElseThrow(() ->
                new RuntimeException("Figura nao encontrada"));
        Figura figuraAtualizado = Figura.builder()
                .nome(figura.getNome() != null ? figura.getNome() :
                        figuraEntity.getNome())
                .profissao(figura.getProfissao() != null ? figura.getProfissao() :
                        figuraEntity.getProfissao())
                .nacionalidade(figura.getNacionalidade() != null ? figura.getNacionalidade() :
                        figuraEntity.getNacionalidade())
                .ano(figura.getAno() != null ? figura.getAno() :
                        figuraEntity.getAno())
                .id(figuraEntity.getId())
                .build();

        repository.saveAndFlush(figuraAtualizado);
    }
}
