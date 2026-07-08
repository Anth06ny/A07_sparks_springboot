package org.example.a07_sparks_springboot.service;

import jakarta.transaction.Transactional;
import org.example.a07_sparks_springboot.model.MessageEntity;
import org.example.a07_sparks_springboot.repository.MessageRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@SpringBootTest
@Transactional
public class MessageServiceTest {

    //Création d'un Mock
    @Mock
    private MessageRepository messageRepository; //= Mockito.mock(MessageRepository.class);

    @InjectMocks
    private  MessageService messageService;

    @Test
    public void testCreateMockMessage() {
        // Préparation des données
        MessageEntity messageEntity = new MessageEntity(0, "Alice", "Hello World");

        // Exécution de la méthode à tester
        messageService.addMessage(messageEntity);

        //On vérifie que la méthode save du repository est bien appelée 1 fois avec le bon argument
        verify(messageRepository, times(1)).save(messageEntity);
    }



    @Test
    public void testAddMessage() {
        // Préparation des données
        MessageEntity messageEntity = new MessageEntity(0, "Alice", "Hello World");

        // Exécution de la méthode à tester
        messageService.addMessage(messageEntity);

        assertTrue(messageEntity.getId() > 0, "L'id n'a pas été modifié");

        // Vérification que messageRepository.save() a été appelé avec le bon argument
        MessageEntity inDatabase = messageService.findById(messageEntity.getId());

        assertNotNull(inDatabase, "Message non retrouvé en base");

        assertEquals(messageEntity, inDatabase, "Les attributs sont différents");
    }




    @Test
    public void testGet10Last() {
        // Préparation des données
        for (int i = 1; i <= 15; i++) {
            MessageEntity message = new MessageEntity(0, "User" + i, "Message " + i);
            messageService.addMessage(message);
        }

        // Exécution de la méthode à tester
        List<MessageEntity> messages = messageService.last10();

        // Vérifications
        assertEquals(10, messages.size());
        assertEquals("Message 15", messages.getFirst().getMessage());
    }

}