package com.figurahistorica.cadastro_figura.infrastructure.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "figura")
@Entity

public class Figura {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "nome", length = 50)
    private String nome;

    @Column(name = "ano")
    private Integer ano;

    @Column(name = "nacionalidade", length = 50)
    private String nacionalidade;

    @Column(name = "profissao", length = 50)
    private String profissao;
}
