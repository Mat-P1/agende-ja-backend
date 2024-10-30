package br.edu.unifametro.aluno.agendeja.repository;

import br.edu.unifametro.aluno.agendeja.domain.business.Business;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BusinessRepository extends JpaRepository<Business, Long> {

    @Query(value = "SELECT " +
            "           b.table_id, b.external_id, b.business_name, b.business_description, b.business_phone_number, b.user_table_id" +
            "       FROM businesses b " +
            "       INNER JOIN users u ON b.user_table_id = u.table_id WHERE u.table_id = ?",
            nativeQuery = true)
    List<Business> findByUserId(Long userId);
}
