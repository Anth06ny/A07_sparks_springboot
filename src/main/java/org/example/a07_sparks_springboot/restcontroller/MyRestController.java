package org.example.a07_sparks_springboot.restcontroller;

import jakarta.validation.Valid;
import org.example.a07_sparks_springboot.model.StudentEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyRestController {




     /* -------------------------------- */
     // Test Sppring Security
     /* -------------------------------- */

    //http://localhost:8080/testPublic
    @GetMapping("/testPublic")
    public String testPublic() {
        System.out.println("/testPublic");
        return "Hello public";
    }

    //http://localhost:8080/testPrivate
    @GetMapping("/testPrivate")
    public String testPrivate() {
        System.out.println("/testPrivate");
        return "Hello private";
    }

    //http://localhost:8080/testPrivateAdmin
    @GetMapping("/testPrivateAdmin")
    public String testPrivateAdmin() {
        System.out.println("/testPrivateAdmin");
        return "Hello private Admin";
    }


    /* -------------------------------- */
    // test get post
    /* -------------------------------- */

    //http://localhost:8080/test
    @GetMapping("/test")
    public String testMethode() {
        System.out.println("/test");

        return "helloWorld";
    }

    //http://localhost:8080/receiveStudent
//Json Attendu : {"name": "toto", "note": 12}
    @PostMapping("/receiveStudent")
    public void receiveStudent( @RequestBody StudentEntity student) {
        System.out.println("/receiveStudent : " + student.getName() + " : " + student.getNote());

        //traitement, mettre en base…
        //Retourner d'autres données
    }

    //http://localhost:8080/getStudent
    @GetMapping("/getStudent")
    public StudentEntity getStudent() {
        System.out.println("/getStudent");

        StudentEntity studentEntity = new StudentEntity(12, "toto");
        return studentEntity;
    }

    //http://localhost:8080/max?p1=-6&p2=tata
    @GetMapping("/max")
    public Integer max(Integer p1, Integer p2) {
        System.out.println("/max p1" + p1 + " p2" + p2);

        if (p1 == null)
            return p2;
        else if (p2 == null) {
            return p1;
        } else {
            return p1 > p2 ? p1 : p2;
        }
    }

    //http://localhost:8080/max2?p1=-6&p2=tata
    @GetMapping("/max2")
    public Integer max(String p1, String p2) {
        System.out.println("/max p1" + p1 + " p2" + p2);

        Integer p1Int = null;
        Integer p2Int = null;

        try {
            p1Int = Integer.parseInt(p1);
        }
        catch(Exception e) {

        }

        try {
            p2Int = Integer.parseInt(p2);
        }
        catch(Exception e) {

        }

        if (p1Int == null)
            return p2Int;
        else if (p2Int == null) {
            return p1Int;
        } else {
            return p1Int > p2Int ? p1Int : p2Int;
        }
    }
}
