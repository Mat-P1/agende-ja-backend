package br.edu.unifametro.aluno.agendeja.service;

import br.edu.unifametro.aluno.agendeja.domain.user.User;
import br.edu.unifametro.aluno.agendeja.domain.user.enums.Role;
import br.edu.unifametro.aluno.agendeja.dto.request.UserRequestDTO;
import br.edu.unifametro.aluno.agendeja.dto.response.UserResponseDTO;
import br.edu.unifametro.aluno.agendeja.mapper.UserMapper;
import br.edu.unifametro.aluno.agendeja.repository.UserRepository;
import br.edu.unifametro.aluno.agendeja.util.user.GovernmentIdValidator;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public UserResponseDTO create(UserRequestDTO userRequestDTO) {

        if (GovernmentIdValidator.isValidGovernmentId(userRequestDTO.governmentId())) {
            User user = UserMapper.INSTANCE.requestDtoToUser(userRequestDTO);
            user.setExternalId(UUID.randomUUID());
            if (GovernmentIdValidator.isCnpj(user.getGovernmentId())) {
                user.setRole(Role.PROVIDER);
            } else {
                user.setRole(Role.CLIENT);
            }
            User savedUser = userRepository.save(user);
            return UserMapper.INSTANCE.userToResponseDTO(savedUser);
        }
        return null;
    }

    @Transactional
    public UserResponseDTO update(Long id, UserRequestDTO userRequestDTO) {
        Optional<User> existingUserOpt = userRepository.findById(id);
        if (existingUserOpt.isPresent()) {
            User existingUser = existingUserOpt.get();

            existingUser.setFirstName(userRequestDTO.firstName());
            existingUser.setLastName(userRequestDTO.lastName());
            existingUser.setEmail(userRequestDTO.email());
            existingUser.setPassword(userRequestDTO.password());

            User savedUser = userRepository.save(existingUser);
            return UserMapper.INSTANCE.userToResponseDTO(savedUser);
        }
        return null;
    }
}