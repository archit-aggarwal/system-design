package spring.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.app.model.User;
import spring.app.repository.UserRepository;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public User saveUser(User user) {
        Long userId = user.getId();
        if (userId != null) {
            Optional<User> userInDb = userRepository.findById(userId);
            if (userInDb.isPresent()) {
                user = updateUser(userInDb.get(), user);
            }
        }
        return userRepository.save(user);
    }

    public User updateUser(User oldUser, User newUser){
        if(newUser.getFirstName() != null) {
            oldUser.setFirstName(newUser.getFirstName());
        }
        if(newUser.getLastName() != null) {
            oldUser.setLastName(newUser.getLastName());
        }
        if(newUser.getEmail() != null) {
            oldUser.setEmail(newUser.getEmail());
        }
        if(newUser.getMobileNo() != null) {
            oldUser.setMobileNo(newUser.getMobileNo());
        }
        return oldUser;
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
