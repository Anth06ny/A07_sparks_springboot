package org.example.a07_sparks_springboot.service;

import org.example.a07_sparks_springboot.model.MessageEntity;
import org.example.a07_sparks_springboot.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    public MessageEntity addMessage(MessageEntity message) {
        messageRepository.save(message);
        return message;
    }

    public MessageEntity findById(Long id) {
        return messageRepository.findById(id).orElse(null);
    }

    public List<MessageEntity> last10() {
        return messageRepository.findTop10ByOrderByIdDesc();
    }

    public List<MessageEntity> getAll() {
        return messageRepository.findAll();
    }
}