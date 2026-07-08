package org.example.a07_sparks_springboot.web;

import org.example.a07_sparks_springboot.model.StudentEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@Controller
public class MyController {

    //http://localhost:8080/hello
    @GetMapping("/hello")
    public String testHello(Model model){
        System.out.println("/hello");

        ArrayList<StudentEntity> liststudent = new ArrayList<>();
        liststudent.add(new StudentEntity(12,"Toto" ));
        liststudent.add(new StudentEntity(14,"Tata" ));

        model.addAttribute("texte", "Bonjour");
        model.addAttribute("studentEntity", new StudentEntity(12,"Toto"));
        model.addAttribute("studentList", liststudent);

        //Nom du fichier HTML que l'on souhaite afficher
        return "welcome";
    }

}