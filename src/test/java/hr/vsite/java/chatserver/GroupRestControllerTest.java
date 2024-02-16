package hr.vsite.java.chatserver;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class GroupRestControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void creategroup() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.put("/groups/test")
                        .content("{\"groupName\":\"test\"}").contentType("application/json"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().is(200));
    }

}
