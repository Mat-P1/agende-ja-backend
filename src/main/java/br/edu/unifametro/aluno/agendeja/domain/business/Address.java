package br.edu.unifametro.aluno.agendeja.domain.business;

import br.edu.unifametro.aluno.agendeja.domain.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "addresses")
@Inheritance(strategy = InheritanceType.JOINED)
@EqualsAndHashCode(callSuper = true)
public class Address extends BaseEntity {

    @Column(name = "street", nullable = false)
    private String street;

    @Column(name = "number", nullable = false)
    private String number;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "state", nullable = false)
    private String state;

    @Column(name = "zip_code", nullable = false)
    private String zip;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "business_table_id")
    private Business business;
}
