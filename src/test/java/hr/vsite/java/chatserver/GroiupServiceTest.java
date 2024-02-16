package hr.vsite.java.chatserver;

import hr.vsite.java.chatserver.db.Group;
import hr.vsite.java.chatserver.domain.GroupService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class GroiupServiceTest {

    @Autowired
    private GroupService groupService;

    @Test
    void createGroup() {
        Group group = new Group();
        group.setGroupName("test");
        groupService.createGroup(group);

        Group group2 = groupService.findGroups("test").get(0);
        Assertions.assertEquals(group.getGroupName(), group2.getGroupName());

        org.assertj.core.api.Assertions.assertThat(group).usingRecursiveComparison().isEqualTo(group2);

    }

    @Test
    void createGroupNullName() {
        Group group = new Group();
        Assertions.assertThrows(RuntimeException.class, () -> groupService.createGroup(group));
    }

    @Test
    void createGroupNull() {
        Group group = null;
        Assertions.assertThrows(RuntimeException.class, () -> groupService.createGroup(group));
    }
}
