package spring.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.app.model.User;
import spring.app.repository.master.MasterUserRepository;
import spring.app.repository.slave.SlaveUserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    MasterUserRepository masterUserRepository;
    SlaveUserRepository slaveUserRepository;

    @Autowired
    public UserService(MasterUserRepository masterUserRepository,
                       SlaveUserRepository slaveUserRepository) {
        this.masterUserRepository = masterUserRepository;
        this.slaveUserRepository = slaveUserRepository;
    }

    @Transactional(readOnly = true)
    public List<User> getAllUsers() {
        return slaveUserRepository.findAll();
    }

    @Transactional(readOnly = true)
    public User getUserById(Long id) {
        return slaveUserRepository.findById(id).orElse(null);
    }

    @Transactional
    public User saveUser(User user) {
        Long userId = user.getId();
        if (userId != null) {
            Optional<User> userInDb = masterUserRepository.findById(userId);
            if (userInDb.isPresent()) {
                user = updateUser(userInDb.get(), user);
            }
        }
        return masterUserRepository.save(user);
    }

    @Transactional
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

    @Transactional
    public void deleteUser(Long id) {
        masterUserRepository.deleteById(id);
    }
}
