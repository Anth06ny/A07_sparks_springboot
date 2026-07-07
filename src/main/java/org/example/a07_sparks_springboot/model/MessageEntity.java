package org.example.a07_sparks_springboot.model;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data //lambock pour les get/set
@Schema(description = "Représente un message dans le tchat")
public class MessageEntity {

    @Schema(description = "Contenu du message", example = "un message")
    @NotBlank(message = "Il faut un pseudo")
    @Size(min = 3, message = "Il faut au moins 3 caractères")
    private String pseudo;

    @Schema(description = "Pseudo de l'utilisateur", example = "toto")
    private String message;


}
