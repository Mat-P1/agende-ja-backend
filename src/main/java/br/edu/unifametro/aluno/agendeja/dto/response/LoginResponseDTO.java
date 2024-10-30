package br.edu.unifametro.aluno.agendeja.dto.response;

import br.edu.unifametro.aluno.agendeja.domain.business.Business;
import br.edu.unifametro.aluno.agendeja.domain.user.User;

import java.util.List;

public record LoginResponseDTO(
        User user,
        List<Business> business,
        boolean success
) {
}
