package radoslaw.webside.authentication.core.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import radoslaw.webside.authentication.core.models.Role;
import radoslaw.webside.authentication.core.models.enums.Roles;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

    Optional<Role> findByRole(Roles roles);
}
