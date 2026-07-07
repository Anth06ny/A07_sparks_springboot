package org.example.a07_sparks_springboot.restcontroller;

import org.example.a07_sparks_springboot.model.UserEntity;
import org.example.a07_sparks_springboot.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/users")
public class UserRestController {


    @PostMapping
    public ResponseEntity<UserEntity> create(@RequestBody UserEntity userEntity){
        var newUser = UserService.save(userEntity);

        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    @GetMapping
    public ArrayList<UserEntity> read(){
        return UserService.load();
    }

    @GetMapping ("/{id}")
    public ResponseEntity<UserEntity> read(@PathVariable long id){

       var user =  UserService.findById(id);

       if(user == null){
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
       }
       else {
             return new ResponseEntity<>(user, HttpStatus.OK);
       }
    }

}
