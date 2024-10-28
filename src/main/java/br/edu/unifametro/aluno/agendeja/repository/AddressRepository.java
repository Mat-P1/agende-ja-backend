package br.edu.unifametro.aluno.agendeja.repository;

import br.edu.unifametro.aluno.agendeja.domain.business.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

    List<Address> findByCity(String city);

    List<Address> findByState(String state);

    List<Address> findByZip(String zip);
}
