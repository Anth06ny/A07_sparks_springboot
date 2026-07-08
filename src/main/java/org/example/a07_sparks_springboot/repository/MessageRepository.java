package org.example.a07_sparks_springboot.repository;

import org.example.a07_sparks_springboot.model.MessageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<MessageEntity, Long> {
    //Attention dans la réalité on utilisera la date car l'id n'est pas forcément dans l'ordre
    List<MessageEntity> findTop10ByOrderByIdDesc();
    List<MessageEntity> findByMessageContainingAndPseudo(String message, String pseudo);
}
