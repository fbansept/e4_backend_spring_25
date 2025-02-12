package edu.fbansept.e4_backend_spring_25.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Etat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    @NotNull(message = "la designation ne peut être null")
    @NotBlank(message = "la designation ne peut pas comporter que des espaces")
    @Size(min = 3, message = "la designation doit comporter au moins 3 caractères")
    private String designation;

}


