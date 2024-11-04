package spring.app.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import spring.app.model.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
}
