package radoslaw.kopec.portfolio.user.auth.users.core.models.enums;

import lombok.Getter;

@Getter
public enum Roles {
    ADMIN("ADMIN"),
    USER("USER");

    private final String role;
    Roles(String value) {
      this.role = value;
    }

}
