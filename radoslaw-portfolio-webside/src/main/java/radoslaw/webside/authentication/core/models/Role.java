package radoslaw.webside.authentication.core.models;

import jakarta.persistence.*;
import lombok.*;
import radoslaw.webside.authentication.core.models.enums.Roles;

@Entity
@Table(name = "roles")
@EqualsAndHashCode
@Setter
@Getter
@NoArgsConstructor
@ToString
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "roleID")
    private int roleId;

    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false, length = 6)
    private Roles role;
}