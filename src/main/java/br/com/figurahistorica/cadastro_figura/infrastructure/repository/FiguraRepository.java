package br.com.figurahistorica.cadastro_figura.infrastructure.repository;

import br.com.figurahistorica.cadastro_figura.infrastructure.entities.Figura;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FiguraRepository extends JpaRepository<Figura, Integer> {

    Optional<Figura> findByNome(String nome);

    @Transactional
    void deleteByNome(String nome);

}
