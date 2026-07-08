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

    //http://localhost:8080/users/1
    //{"login":"aaa", "password":"bbb"}
    @PutMapping("/{id}")
    public ResponseEntity<UserEntity> updateUser(@PathVariable Long id, @RequestBody UserEntity userDetails) {
        UserEntity user = UserService.findById(id);
        if (user != null) {
            userDetails.setId(id);//écrase celui reçu dans le JSON au cas ou
            UserService.save(userDetails);
            return new ResponseEntity<>(userDetails, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //http://localhost:8080/users/1
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        if (UserService.deleteById(id)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
