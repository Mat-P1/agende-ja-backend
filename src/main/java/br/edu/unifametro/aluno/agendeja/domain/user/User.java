package br.edu.unifametro.aluno.agendeja.domain.user;

import br.edu.unifametro.aluno.agendeja.domain.user.enums.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "table_id", nullable = false, updatable = false, unique = true)
    private Long tableId;

    @Column(name = "external_id", nullable = false, updatable = false, unique = true)
    private UUID externalId;

    @Column(name = "government_id", nullable = false, updatable = false, unique = true, length = 14)
    private String governmentId;

    @Column(name = "first_name", nullable = false, length = 30)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 35)
    private String lastName;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password", nullable = false, unique = true, length = 64)
    private char[] password;

    @Column(name = "phone", unique = true, length = 14)
    private String phone;

    @Column(name = "role", nullable = false)
    private Role role;
}
