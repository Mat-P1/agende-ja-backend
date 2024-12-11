package br.edu.unifametro.aluno.agendeja.dto.response;

import java.time.LocalDateTime;
import java.util.UUID;

public record AppointmentResponseDTO(
        UUID externalId,
        Long appointmentId,
        String businessName,
        LocalDateTime start,
        LocalDateTime end,
        String appointmentDescription,
        Long userId,
        Long businessId
) {
}
