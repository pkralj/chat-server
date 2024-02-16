package hr.vsite.java.chatserver.domain;

import hr.vsite.java.chatserver.db.Message;
import hr.vsite.java.chatserver.db.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class MessageService {
    @Autowired
    private final MessageRepository messageRepository;

    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public List<Message> getMessages() {
        return messageRepository.findAll();
    }

    public List<Message> findMessages(int Id) {
        return messageRepository.findMessageById(Id);
    }

    public int createMessage(Message message) {
        if (!StringUtils.hasText(message.getMessage()) || message.getUser() == null || message.getGroup()  == null) {
            throw new RuntimeException("Message, user and group must be provided");
        }
        return messageRepository.save(message).getId();
    }

    public void deleteMessage(int id) {
        messageRepository.deleteById(id);
    }
}
