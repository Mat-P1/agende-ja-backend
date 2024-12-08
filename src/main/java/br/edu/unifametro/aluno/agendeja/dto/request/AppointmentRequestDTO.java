package br.edu.unifametro.aluno.agendeja.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

public record AppointmentRequestDTO(

        @NotNull(message = "Field 'start' must not be null")
        @FutureOrPresent(message = "Field 'start' must be in the present or future")
        @JsonFormat(pattern = "dd-MM-yyyy'T'HH:mm", shape = JsonFormat.Shape.STRING)
        LocalDateTime start,

        @NotNull(message = "Field 'end' must not be null")
        @FutureOrPresent(message = "Field 'end' must be in the present or future")
        @JsonFormat(pattern = "dd-MM-yyyy'T'HH:mm", shape = JsonFormat.Shape.STRING)
        LocalDateTime end,

        @NotBlank(message = "Field 'appointment description' must not be empty")
        @Size(max = 40, message = "Field 'appointment description' must be at most 40 characters long")
        String appointmentDescription,

        @NotNull(message = "Field 'userId' must not be null")
        Long userId,

        @NotNull(message = "Field 'businessId' must not be null")
        Long businessId
) {
}
