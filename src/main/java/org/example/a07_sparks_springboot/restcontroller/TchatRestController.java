package org.example.a07_sparks_springboot.restcontroller;

import jakarta.validation.Valid;
import org.example.a07_sparks_springboot.model.MessageEntity;
import org.example.a07_sparks_springboot.service.MessageService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tchat")
public class TchatRestController {

    @Value("${my.custom.value}")
    String customProperty;

    private final MessageService messageService;

    public TchatRestController(MessageService messageService) {
        this.messageService = messageService;
    }


    //http://localhost:8080/tchat/saveMessage
    @PostMapping("/saveMessage")
    public void saveMessage(@Valid @RequestBody MessageEntity message) {
        System.out.println("/saveMessage : " + message.getMessage() + " : " + message.getPseudo());

        messageService.addMessage(message);
    }



//    //http://localhost:8080/tchat/addMessage?pseudo=toto&message=coucou
//    @GetMapping("/addMessage")
//    public ArrayList<MessageEntity> addMessage(String pseudo, String message) {
//        System.out.println("/addMessage : " + message + " : " + pseudo);
//        MessageEntity newMessage = new MessageEntity();
//        newMessage.setPseudo(pseudo);
//        newMessage.setMessage(message);
//        list.add(newMessage);
//
//        return list;
//    }

    //http://localhost:8080/tchat/addMessage?pseudo=toto&message=coucou
    @GetMapping("/addMessage")
    public List<MessageEntity> addMessage(@Valid MessageEntity message) {
        System.out.println("/addMessage : " + message);

        messageService.addMessage(message);

        return messageService.getAll();
    }

    @GetMapping("/allMessages")
    public List<MessageEntity> allMessages() {
        System.out.println("/allMessages");

        return messageService.last10();
    }

//    //Ne garde que les 5 derniers messages toutes les minutes
//    @Scheduled(fixedRate = 60000)
//    public void nettoyage() {
//        System.out.println("Nettoyage : " + list.size() + " messages");
//        if (list.size() > 5) {
//            list = new ArrayList<>(list.subList(list.size() - 5, list.size()));
//        }
//    }

}
