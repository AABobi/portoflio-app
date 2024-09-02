package radoslaw.kopec.portfolio.user.auth.users.core.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import radoslaw.kopec.portfolio.user.auth.users.core.models.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

   /* @Query("""
          SELECT cv FROM User cv
    """)*/
    Optional<User> findByEmail(String email);
}
