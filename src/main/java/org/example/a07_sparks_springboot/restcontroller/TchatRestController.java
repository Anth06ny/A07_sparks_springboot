package org.example.a07_sparks_springboot.restcontroller;

import jakarta.validation.Valid;
import org.example.a07_sparks_springboot.model.MessageEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/tchat")
public class TchatRestController {

    private ArrayList<MessageEntity> list = new ArrayList<>();

    //http://localhost:8080/tchat/saveMessage
    @PostMapping("/saveMessage")
    public void saveMessage(@Valid  @RequestBody MessageEntity message) {
        System.out.println("/saveMessage : " + message.getMessage() + " : " + message.getPseudo());
        list.add(message);
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
    public ArrayList<MessageEntity> addMessage(@Valid MessageEntity message) {
        System.out.println("/addMessage : " + message );

        list.add(message);

        return list;
    }

    @GetMapping("/allMessages")
    public ArrayList<MessageEntity> allMessages() {
        System.out.println("/allMessages");

        //pour ne retourner que les 10 derniers
        ArrayList<MessageEntity> toReturn = new ArrayList<>();
        for (int i = Math.max(list.size() - 10, 0); i < list.size(); i++) {
            toReturn.add(list.get(i));
        }

        return toReturn;
    }

    //Ne garde que les 5 derniers messages toutes les minutes
    @Scheduled(fixedRate = 60000)
    public void nettoyage() {
        System.out.println("Nettoyage : " + list.size() + " messages");
        if (list.size() > 5) {
            list = new ArrayList<>(list.subList(list.size() - 5, list.size()));
        }
    }

}
