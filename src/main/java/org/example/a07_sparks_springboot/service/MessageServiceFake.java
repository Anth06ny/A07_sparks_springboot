package org.example.a07_sparks_springboot.service;

import org.example.a07_sparks_springboot.model.MessageEntity;

import java.util.List;

public class MessageServiceFake {
    public List<MessageEntity> last10() {
        return List.of();
    }
}
