package br.edu.unifametro.aluno.agendeja.repository;

import br.edu.unifametro.aluno.agendeja.domain.business.Business;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusinessRepository extends JpaRepository<Business, Long> {

}
