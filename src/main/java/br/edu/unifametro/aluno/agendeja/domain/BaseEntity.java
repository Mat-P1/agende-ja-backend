package br.edu.unifametro.aluno.agendeja.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@MappedSuperclass
@Setter
@Getter
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "table_id", nullable = false, updatable = false, unique = true)
    private Long id;

    @Column(name = "external_id", nullable = false, updatable = false, unique = true)
    private UUID externalId;
}
