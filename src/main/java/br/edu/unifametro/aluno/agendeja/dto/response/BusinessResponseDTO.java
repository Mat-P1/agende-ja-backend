package br.edu.unifametro.aluno.agendeja.dto.response;

import java.util.UUID;

public record BusinessResponseDTO (
        UUID userExternalId,
        String userGovernmentId,
        String userFirstName,
        String userLastName,
        Long businessId,
        String businessName,
        String businessDescription,
        String businessPhoneNumber
) {
}
