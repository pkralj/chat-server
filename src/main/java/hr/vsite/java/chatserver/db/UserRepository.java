package hr.vsite.java.chatserver.db;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface UserRepository extends JpaRepository<User, String> {
    public List<User> findByUserNameStartsWith(String userName);
    public List<User> findByUserNameContainingIgnoreCase (String userName);
}
