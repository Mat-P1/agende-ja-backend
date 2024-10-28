package br.edu.unifametro.aluno.agendeja.dto.request;

import br.edu.unifametro.aluno.agendeja.domain.booking.enums.AppointmentStatus;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

public record AppointmentRequestDTO(

        @NotNull(message = "Field 'start' must not be null")
        @FutureOrPresent(message = "Field 'start' must be in the present or future")
        @DateTimeFormat(pattern = "dd-MM-yyyy'T'HH:mm")
        LocalDateTime start,

        @NotNull(message = "Field 'end' must not be null")
        @FutureOrPresent(message = "Field 'end' must be in the present or future")
        @DateTimeFormat(pattern = "dd-MM-yyyy'T'HH:mm")
        LocalDateTime end,

        @NotNull(message = "Field 'status' must not be null")
        AppointmentStatus status,

        @NotBlank(message = "Field 'appointment description' must not be empty")
        @Size(max = 40, message = "Field 'appointment description' must be at most 40 characters long")
        String appointmentDescription,

        @NotNull(message = "Field 'userId' must not be null")
        Long userId,

        @NotNull(message = "Field 'businessId' must not be null")
        Long businessId
) {
}
