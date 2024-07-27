package spring.app.repository.master;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.app.model.User;

@Repository
public interface MasterUserRepository extends JpaRepository<User, Long> {
}
