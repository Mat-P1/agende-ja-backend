package br.edu.unifametro.aluno.agendeja.util.role;

import br.edu.unifametro.aluno.agendeja.domain.user.enums.Role;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.stream.Stream;

@Converter(autoApply = true)
public class RoleConverter implements AttributeConverter<Role, String> {

    @Override
    public String convertToDatabaseColumn(Role role) {
        if (role == null) {
            return null;
        }
        return role.getAuthority();
    }

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
