package hr.vsite.java.chatserver.db;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface GroupRepository extends JpaRepository<Group, String> {
    public List<Group> findByGroupNameStartsWith(String groupName);
    public List<Group> findByGroupNameContainingIgnoreCase (String groupName);
}