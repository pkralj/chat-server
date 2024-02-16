package hr.vsite.java.chatserver.domain;

import hr.vsite.java.chatserver.db.User;
import org.springframework.beans.factory.annotation.Autowired;
import hr.vsite.java.chatserver.db.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public List<User> findUsers(String userName) {
        return userRepository.findByUserNameStartsWith(userName);
    }

    public void createUser(User user) {
        if (!StringUtils.hasText(user.getUserName())) {
            throw new RuntimeException("Username must be provided");
        }
        userRepository.save(user);
    }

    public void deleteUser(String userName) {
        userRepository.deleteById(userName);
    }
}
