package br.edu.unifametro.aluno.agendeja.dto.response;

import java.util.UUID;

public record AddressResponseDTO(
        UUID externalId,
        String street,
        String number,
        String city,
        String state,
        String zip,
        Long businessId
) {
}
