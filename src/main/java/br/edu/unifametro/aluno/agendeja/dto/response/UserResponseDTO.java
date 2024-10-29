package br.edu.unifametro.aluno.agendeja.dto.response;

import br.edu.unifametro.aluno.agendeja.domain.user.enums.Role;

import java.util.UUID;

public record UserResponseDTO(
        UUID externalId,
        String governmentId,
        String firstName,
        String lastName,
        String email,
        Role role,
        boolean cpfServiceProvider
) {
}
