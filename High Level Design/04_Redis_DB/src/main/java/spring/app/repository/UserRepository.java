package spring.app.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import spring.app.model.User;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class UserRepository {
    private final RedisTemplate<String, User> redisTemplate;
    private final String key = "users";

    @Autowired
    UserRepository(RedisTemplate<String, User> redisTemplate){
        this.redisTemplate = redisTemplate;
    }

    public User save(User user){
        redisTemplate.opsForHash().put(key, user.getId(), user);
        return (User) redisTemplate.opsForHash().get(key, user.getId());
    }

    public Optional<User> findById(Long id){
        User user = (User) redisTemplate.opsForHash().get(key, id);
        if(user == null) return Optional.empty();
        else return Optional.of(user);
    }

    public List<User> findAll() {
        Map<Object, Object> map = redisTemplate.opsForHash().entries(key);
        return map.values().stream().map(obj -> (User)obj).toList();
    }

    public void deleteById(Long id){
        redisTemplate.opsForHash().delete(key, id);
    }
}
