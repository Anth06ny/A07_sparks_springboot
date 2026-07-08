package org.example.a07_sparks_springboot.model;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //lambock pour les get/set
@Schema(description = "Représente un message dans le tchat")
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "message")
public class MessageEntity {

    @Id
    ///ID auto incrémenté
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Schema(description = "Contenu du message", example = "un message")
    @NotBlank(message = "Il faut un pseudo")
    @Size(min = 3, message = "Il faut au moins 3 caractères")
    private String pseudo;

    @Schema(description = "Pseudo de l'utilisateur", example = "toto")
    private String message;


}
