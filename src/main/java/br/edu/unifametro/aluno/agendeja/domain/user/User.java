package br.edu.unifametro.aluno.agendeja.domain.user;

import br.edu.unifametro.aluno.agendeja.domain.BaseEntity;
import br.edu.unifametro.aluno.agendeja.domain.user.enums.Role;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@EqualsAndHashCode(callSuper = true)
@Table(name = "users")
public class User extends BaseEntity {

    @Column(name = "government_id", nullable = false, updatable = false, length = 14)
    private String governmentId;

    @Column(name = "first_name", nullable = false, length = 30)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 35)
    private String lastName;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password", nullable = false, length = 64)
    private char[] password;

    @Column(name = "role", nullable = false, length = 10)
    private Role role;

    @Column(name = "cpfServiceProvider", nullable = false)
    private boolean cpfServiceProvider;
}