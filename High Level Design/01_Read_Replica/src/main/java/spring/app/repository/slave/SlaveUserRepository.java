package spring.app.repository.slave;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.app.model.User;

@Repository
public interface SlaveUserRepository extends JpaRepository<User, Long> {
}
