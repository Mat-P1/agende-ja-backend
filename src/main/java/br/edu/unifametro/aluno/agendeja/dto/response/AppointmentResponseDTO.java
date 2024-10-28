package br.edu.unifametro.aluno.agendeja.dto.response;

import br.edu.unifametro.aluno.agendeja.domain.booking.enums.AppointmentStatus;

import java.time.LocalDateTime;
import java.util.UUID;

public record AppointmentResponseDTO(
        UUID externalId,
        LocalDateTime start,
        LocalDateTime end,
        AppointmentStatus status,
        String appointmentDescription,
        Long userId,
        Long businessId
) {
}
