package edu.fbansept.e4_backend_spring_25.model;

import com.fasterxml.jackson.annotation.JsonView;
import edu.fbansept.e4_backend_spring_25.view.CommandeView;
import edu.fbansept.e4_backend_spring_25.view.UtilisateurView;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView({CommandeView.class, UtilisateurView.class})
    private Integer id;

    @Column(nullable = false, unique = true)
    @NotNull(message = "L'email ne peut être null")
    @Email(message = "L'email est mal formé")
    @JsonView(UtilisateurView.class)
    private String email;

    @Column(nullable = false, length = 255)
    //@Size(min = 3, max = 30, message = "Le mot de passe doit contenir 3 à 30 caractères")
    //@Length(min = 3, max = 30, message = "Le mot de passe doit contenir 3 à 30 caractères")
    @NotBlank(message = "Le mot de passe ne peut être vide, null ou ne comporter que des espaces")
    private String password;

    @JsonView(UtilisateurView.class)
    private boolean administrateur;

    @JsonView({CommandeView.class, UtilisateurView.class})
    private boolean actif;
}

