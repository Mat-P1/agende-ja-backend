package br.edu.unifametro.aluno.agendeja.util.role;

import br.edu.unifametro.aluno.agendeja.domain.user.enums.Role;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.stream.Stream;

/**
 * RoleConverter is a JPA attribute converter used to convert {@link Role} enums to their corresponding string representation
 * for storage in the database and vice versa. It implements {@link AttributeConverter} to handle the conversion between
 * {@link Role} and {@link String}.
 * <p>
 * Annotations:
 * - {@link @Converter(autoApply = true)}: Marks this class as a JPA converter, with `autoApply` set to true,
 *   meaning it will automatically apply this converter to any entity attribute of type {@link Role}.
 * <p>
 * Methods:
 * - {@link #convertToDatabaseColumn(Role)}: Converts a {@link Role} to a {@link String} for storing in the database.
 * - {@link #convertToEntityAttribute(String)}: Converts a {@link String} from the database back into a {@link Role} enum.
 */

@Converter(autoApply = true)
public final class RoleConverter implements AttributeConverter<Role, String> {

    /**
     * Converts a {@link Role} to its corresponding string representation (authority) for storing in the database.
     * If the provided role is null, it returns null.
     *
     * @param role The {@link Role} to be converted to a {@link String}.
     * @return The authority string of the {@link Role}, or null if the role is null.
     */

    @Override
    public String convertToDatabaseColumn(Role role) {
        if (role == null) {
            return null;
        }
        return role.getAuthority();
    }

    /**
     * Converts a {@link String} retrieved from the database into the corresponding {@link Role} enum.
     * If the provided string is null, it returns null.
     * If no matching {@link Role} is found, it throws an {@link IllegalArgumentException}.
     *
     * @param role The string representation of the role from the database.
     * @return The corresponding {@link Role} enum, or null if the string is null.
     * @throws IllegalArgumentException if no matching {@link Role} is found.
     */

    @Override
    public Role convertToEntityAttribute(String role) {
        if (role == null) {
            return null;
        }
        return Stream.of(Role.values())
                .filter(r -> r.getAuthority().equals(role))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}