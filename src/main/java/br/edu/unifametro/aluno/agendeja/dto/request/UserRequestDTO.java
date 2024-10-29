package br.edu.unifametro.aluno.agendeja.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record UserRequestDTO(

        @NotBlank
        String externalId,

        @NotBlank(message = "Field 'government Id' must not be empty") @Size(min = 11, max = 14, message = "Field 'government Id' must be between 11 and 14")
        @Pattern(regexp = "^[0-9]*$", message = "Field 'government Id' must contain only numerals")
        String governmentId,

        @NotBlank(message = "Field 'first name' must not be empty") @Size(min = 3, max = 30, message = "Field 'first name' must be between 3 and 30")
        @Pattern(regexp = "^[A-ZÀ-ÖØ-ÝĀ-ŽÀ-ÿÇ][a-zà-öø-ÿā-žç]+(?:[-' ][A-ZÀ-ÖØ-ÝĀ-ŽÀ-ÿÇ][a-zà-öø-ÿā-žç]+)?$", message = "Field 'first name' must contain valid letters")
        String firstName,

        @NotBlank(message = "Field 'last name' must not be empty") @Size(min = 3, max = 35, message = "Field 'last name' must be between 3 and 35")
        @Pattern(regexp = "^[A-ZÀ-ÖØ-ÝĀ-ŽÀ-ÿÇ][a-zà-öø-ÿā-žç]+(?:[-' ][A-ZÀ-ÖØ-ÝĀ-ŽÀ-ÿÇ][a-zà-öø-ÿā-žç]+)?$", message = "Field 'last name' must contain valid letters")
        String lastName,

        @NotBlank(message = "Field 'email' must not be empty")
        @Email(message = "Field 'email' must be an email")
        String email,

        @NotBlank(message = "Field 'password' must not be empty")
        @Size(min = 8, max = 64, message = "Field 'password' must be between 8 and 64 characters long")
        @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[\\W_])^[\\x21-\\x7e]{8,64}$", message = "Password must contain at least one digit, one lowercase letter, one upper case letter and one special character")
        char[] password,

        @NotBlank String role,

        @NotBlank boolean cpfServiceProvider
) {
}
