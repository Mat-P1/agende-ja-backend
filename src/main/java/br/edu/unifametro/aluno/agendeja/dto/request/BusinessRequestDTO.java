package br.edu.unifametro.aluno.agendeja.dto.request;

import br.edu.unifametro.aluno.agendeja.domain.user.User;

public record BusinessRequestDTO(
        User user,
        String businessName,
        String businessDescription,
        String businessPhoneNumber
) {
}
