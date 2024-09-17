package br.edu.unifametro.aluno.agendeja.service;

import br.edu.unifametro.aluno.agendeja.repository.UserRepository;
import br.edu.unifametro.aluno.agendeja.request.login.LoginRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final UserRepository userRepository;

    public Optional<Boolean> findByEmail(LoginRequest loginRequest) {
        var user = userRepository.findByEmail(loginRequest.email());

        if (user.isEmpty()) {
            throw new BadCredentialsException("User not found");
        } else if (!Arrays.equals(user.get().getPassword(), loginRequest.password()) || !user.get().getEmail().equals(loginRequest.email())) {
            throw new BadCredentialsException("Invalid email or password");
        } else {
            return Optional.of(true);
        }
    }
}
