package br.edu.unifametro.aluno.agendeja.service;

import br.edu.unifametro.aluno.agendeja.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

}
