package br.edu.unifametro.aluno.agendeja.domain.user.enums;

import br.edu.unifametro.aluno.agendeja.util.role.RoleType;
import org.springframework.security.core.GrantedAuthority;

/**
 * Enum representing different roles in the system, each with a specific authority.
 * Implements the {@link GrantedAuthority} interface from Spring Security to integrate role-based authentication.
 * <p>
 * Roles:
 * - ADMIN: Represents administrative users with full system privileges.
 * - PROVIDER: Represents service providers with specific system access.
 * - CLIENT: Represents clients or customers with limited access to the system.
 * <p>
 * Each role is associated with a specific authority, defined by {@link RoleType}.
 * The enum provides methods to retrieve the authority for each role.
 * <p>
 * Implements:
 * - {@link GrantedAuthority}: Provides a method to retrieve the authority granted to the role.
 */

public enum Role implements GrantedAuthority {
    ADMIN(RoleType.ADMIN),
    PROVIDER(RoleType.PROVIDER),
    CLIENT(RoleType.CLIENT);

    private final String authority;

    /**
     * Constructor to initialize the role with its corresponding authority.
     *
     * @param authority The string representation of the role's authority, typically defined in {@link RoleType}.
     */

    Role(String authority) {
        this.authority = authority;
    }

    /**
     * Returns the authority granted to this role.
     * This method is required by the {@link GrantedAuthority} interface and is used by Spring Security.
     *
     * @return The authority string associated with this role.
     */

    @Override
    public String getAuthority() {
        return authority;
    }
}