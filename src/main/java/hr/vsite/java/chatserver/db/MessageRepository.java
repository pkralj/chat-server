package hr.vsite.java.chatserver.db;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Integer> {
    public List<Message> findMessageById(int Id);
}
