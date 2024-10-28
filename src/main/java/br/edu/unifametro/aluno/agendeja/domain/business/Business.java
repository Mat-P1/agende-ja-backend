package br.edu.unifametro.aluno.agendeja.domain.business;

import br.edu.unifametro.aluno.agendeja.domain.BaseEntity;
import br.edu.unifametro.aluno.agendeja.domain.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@EqualsAndHashCode(callSuper = true)
@Table(name = "businesses")
public class Business extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_table_id")
    private User user;

    @Column(name = "business_name", nullable = false, unique = true, length = 60)
    private String businessName;

    @Column(name = "business_description", nullable = false, length = 350)
    private String businessDescription;

    @Column(name = "business_phone_number", nullable = false, unique = true, length = 14)
    private String businessPhoneNumber;
}
