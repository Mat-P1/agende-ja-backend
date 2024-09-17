package br.edu.unifametro.aluno.agendeja.service;

import br.edu.unifametro.aluno.agendeja.domain.user.User;
import br.edu.unifametro.aluno.agendeja.domain.user.enums.Role;
import br.edu.unifametro.aluno.agendeja.mapper.UserMapper;
import br.edu.unifametro.aluno.agendeja.repository.UserRepository;
import br.edu.unifametro.aluno.agendeja.request.user.UserPostRequestBody;
import br.edu.unifametro.aluno.agendeja.util.user.GovernmentIdValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * UserService is responsible for handling business logic related to user creation and management.
 * It interacts with the {@link UserRepository} for persistence and applies validation rules for user data.
 * <p>
 * Fields:
 * - {@link UserRepository}: A repository for managing user entities in the database.
 * <p>
 * Methods:
 * - {@link #create(UserPostRequestBody)}: Handles user creation, including government ID validation, assigning roles based on the type of ID, generating an external ID, and saving the user.
 */

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    /**
     * Creates a new user after performing validations and assigning the appropriate role.
     * The user's government ID is validated, and based on the type of government ID (CNPJ or CPF),
     * the appropriate role (Provider or Client) is assigned.
     * <p>
     * - If the government ID is valid, an external ID is generated for the user.
     * - If the government ID is a CNPJ, the user is assigned the role of {@link Role#PROVIDER}, otherwise {@link Role#CLIENT}.
     * - The user data is then converted from a {@link UserPostRequestBody} to a {@link User} entity using {@link UserMapper}
     *   and saved to the repository.
     *
     * @param user The {@link UserPostRequestBody} containing the user's registration details.
     * @return The created {@link User} if the government ID is valid, otherwise returns null.
     */

    public User create(UserPostRequestBody user) {

        if (GovernmentIdValidator.isValidGovernmentId(user.getGovernmentId())) {
            user.setExternalId(UUID.randomUUID().toString());
            if (GovernmentIdValidator.isCnpj(user.getGovernmentId())) {
                user.setRole(Role.PROVIDER.getAuthority());
            } else {
                user.setRole(Role.CLIENT.getAuthority());
            }
            userRepository.save(UserMapper.INSTANCE.postRequestBodyToUser(user));
        }

        return UserMapper.INSTANCE.postRequestBodyToUser(user);
    }
}