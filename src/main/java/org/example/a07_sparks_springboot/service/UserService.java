package org.example.a07_sparks_springboot.service;

import org.example.a07_sparks_springboot.model.UserEntity;

import java.util.ArrayList;
import java.util.Objects;

public class UserService {

    private static final ArrayList<UserEntity> list = new ArrayList<>();
    private static long idNumber = 1;

//Jeu de donnée si besoin
//    static {
//        list.add(new UserEntity(1L, "toto", "aaa"));
//        list.add(new UserEntity(2L, "tata", "bbb"));
//    }

    public static void main(String[] args){
        UserService.save(new UserEntity(1L, "Toto", "abcd"));
        System.out.println(UserService.findById(1L));
    }

    //Sauvegarde Create or Update
    public static UserEntity save(UserEntity user) {
        //On regarde s'il n'est pas déjà en base
        UserEntity userRegister = findById(user.getId());
        if (userRegister != null) {
            //on retire celui en base pour remplacer par celui la
            list.remove(userRegister);
        } else {
            //on ajoute un id généré
            user.setId(idNumber++);
        }
        list.add(user);
        return user;
    }

    //Retourne la liste
    public static ArrayList<UserEntity> load() {
        return list;
    }

    //Permet de trouver l'utilisateur qui utilise cette session
    public static UserEntity findById(Long id) {
        if (id != null) {
            for (UserEntity userEntity : list) {
                if (Objects.equals(userEntity.getId(), id)) {
                    return userEntity;
                }
            }
        }
        //Pas d'utilisateur qui a cette session
        return null;
    }

    //Supprime l'élément.Retourne true si la liste a changé
    public static boolean deleteById(Long id) {
        return list.removeIf(user -> Objects.equals(user.getId(), id));
    }

}