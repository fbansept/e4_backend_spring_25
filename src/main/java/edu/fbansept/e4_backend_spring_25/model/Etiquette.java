package edu.fbansept.e4_backend_spring_25.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Etiquette {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    @NotNull(message = "la designation ne peut être null")
    @Pattern(regexp = "^\\s*\\S{3,}\\s*$", message = "la designation doit comporter 3 caractères (en excluant les espaces)")
    private String designation;

    private String couleur;

}


