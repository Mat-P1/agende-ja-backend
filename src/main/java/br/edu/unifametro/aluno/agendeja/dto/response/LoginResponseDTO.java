package br.edu.unifametro.aluno.agendeja.dto.response;

import br.edu.unifametro.aluno.agendeja.domain.user.User;

public record LoginResponseDTO(
        User user,
        boolean success
) {
}
