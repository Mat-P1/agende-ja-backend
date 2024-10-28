package br.edu.unifametro.aluno.agendeja.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record AddressRequestDTO(
        @NotBlank(message = "Field 'street' must not be empty")
        @Size(max = 100, message = "Field 'street' must be at most 100 characters long")
        String street,

        @NotBlank(message = "Field 'number' must not be empty")
        @Size(max = 10, message = "Field 'number' must be at most 10 characters long")
        String number,

        @NotBlank(message = "Field 'city' must not be empty")
        @Size(max = 50, message = "Field 'city' must be at most 50 characters long")
        String city,

        @NotBlank(message = "Field 'state' must not be empty")
        @Size(max = 50, message = "Field 'state' must be at most 50 characters long")
        String state,

        @NotBlank(message = "Field 'zip' must not be empty")
        @Size(max = 20, message = "Field 'zip' must be at most 20 characters long")
        String zip,

        Long businessId
) {
}
