package br.edu.unifametro.aluno.agendeja.repository;

import br.edu.unifametro.aluno.agendeja.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
