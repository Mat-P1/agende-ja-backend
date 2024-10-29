package br.edu.unifametro.aluno.agendeja.dto.response;

import java.util.UUID;

public record BusinessResponseDTO (
        UUID userExternalId,
        String businessName,
        String businessDescription,
        String businessPhoneNumber
) {
}
