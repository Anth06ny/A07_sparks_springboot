package org.example.a07_sparks_springboot.web;

import org.example.a07_sparks_springboot.model.StudentEntity;
import org.example.a07_sparks_springboot.model.UserEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    //http://localhost:8080/login
    @GetMapping("/login")
    public String login(UserEntity userEntity) {
        System.out.println("/login");
        //Spring créera une instance de UserEntity qu'il mettra dans le model
        return "login";
    }

    //Méthode appelée par le formulaire
    @PostMapping("/loginSubmit")
    public String loginSubmit(UserEntity userEntity, RedirectAttributes redirect) {
        System.out.println("/loginSubmit : User=" + userEntity.getLogin() + " " + userEntity.getPassword());

        try {
            if (userEntity.getLogin().isBlank()) {
                throw new Exception("Login manquant");
            }
            if (userEntity.getPassword().isBlank()) {
                throw new Exception("Password manquant");
            }
            //Cas qui marche
            redirect.addFlashAttribute("userEntity", userEntity);
            return "redirect:userRegister";// Redirection sur /userRegister
        }
        catch (Exception e) {
            e.printStackTrace();

            //Cas d'erreur
            //pour garder les données entrées dans le formulaire par l'utilisateur
            redirect.addFlashAttribute("userEntity", userEntity) ;
            //Pour transmettre le message d'erreur
            redirect.addFlashAttribute("errorMessage", e.getMessage());
            return "redirect:login"; //Redirige sur /login
        }
    }

    @GetMapping("/userRegister") //Affiche la page résultat
    public String userRegister() {
        return "userRegister";  //Lance userRegister.html
    }


}