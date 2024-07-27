package spring.app.repository.users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.app.model.users.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
