package radoslaw.webside.authentication.core.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users")
@EqualsAndHashCode
@Setter
@Getter
@NoArgsConstructor
@ToString
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userID")
    private int userId;

    @Column(name = "name")
    private String name;

    @Column(name = "email" )
    private String email;

    @Column(name = "password")
    private String password;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "roleID", nullable = false)
    private Role role;
}