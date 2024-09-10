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

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

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

        return null;
    }
}
