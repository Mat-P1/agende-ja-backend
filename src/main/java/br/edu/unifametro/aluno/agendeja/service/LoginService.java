package br.edu.unifametro.aluno.agendeja.service;

import br.edu.unifametro.aluno.agendeja.dto.request.LoginRequestDTO;
import br.edu.unifametro.aluno.agendeja.dto.response.LoginResponseDTO;
import br.edu.unifametro.aluno.agendeja.repository.BusinessRepository;
import br.edu.unifametro.aluno.agendeja.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final UserRepository userRepository;
    private final BusinessRepository businessRepository;

    public Optional<LoginResponseDTO> findByEmail(LoginRequestDTO loginRequestDTO) {
        var user = userRepository.findByEmail(loginRequestDTO.email());

        if (user.isEmpty()) {
            throw new BadCredentialsException("User not found");
        } else if (!Arrays.equals(user.get().getPassword(), loginRequestDTO.password().toCharArray()) || !user.get().getEmail().equals(loginRequestDTO.email())) {
            throw new BadCredentialsException("Invalid email or password");
        } else {
            var business = businessRepository.findByUserId(user.get().getId());

            return Optional.of(new LoginResponseDTO(user.get(), business, true));
        }
    }
}
