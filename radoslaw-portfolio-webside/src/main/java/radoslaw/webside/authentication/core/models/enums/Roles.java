package radoslaw.webside.authentication.core.models.enums;

import lombok.Getter;

@Getter
public enum Roles {
    ADMIN("ADMIN"),
    USER("USER");
    Roles(String role) {
        this.role = role;
    }

    private final String role;
}
