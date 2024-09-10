package br.edu.unifametro.aluno.agendeja.repository;

import br.edu.unifametro.aluno.agendeja.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * UserRepository is a repository interface for managing {@link User} entities in the database.
 * It extends the {@link JpaRepository} interface provided by Spring Data JPA, which offers CRUD operations
 * and other methods for working with the persistence layer.
 * <p>
 * This interface allows interaction with the database for operations such as saving, deleting, and retrieving {@link User} entities.
 * <p>
 * Type Parameters:
 * - {@link User}: The entity type that this repository manages.
 * - {@link Long}: The type of the primary key (ID) for the {@link User} entity.
 * <p>
 * No additional methods are defined here, but the {@link JpaRepository} provides various methods such as:
 * - save()
 * - findById()
 * - findAll()
 * - deleteById()
 */

public interface UserRepository extends JpaRepository<User, Long> {

}