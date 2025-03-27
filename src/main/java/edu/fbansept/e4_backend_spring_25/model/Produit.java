package edu.fbansept.e4_backend_spring_25.model;

import com.fasterxml.jackson.annotation.JsonView;
import edu.fbansept.e4_backend_spring_25.view.CommandeView;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Produit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(CommandeView.class)
    private Integer id;

    @Column(nullable = false)
    @NotBlank(message = "Le nom ne peut être vide, null ou ne comporter que des espaces")
    @JsonView(CommandeView.class)
    private String nom;

    @Column(unique = true, nullable = false, length = 50)
    @Size(min = 3, max = 50, message = "Le code doit avoir entre 3 et 50 caractères")
    @NotBlank(message = "Le code ne peut être vide, null ou ne comporter que des espaces")
    @JsonView(CommandeView.class)
    private String code;

    @Column(columnDefinition = "TEXT")
    private String description;

    @DecimalMin(value = "0", message = "le prix doit être positif")
    private float prix;

    @ManyToOne(optional = false)
    @NotNull(message = "L'état ne peut être null")
    private Etat etat;

    @ManyToMany
    @JoinTable(
            name = "etiquette_produit",
            joinColumns = @JoinColumn(name = "produit_id", foreignKey = @ForeignKey(name = "FK_etiquette_produit")),
            inverseJoinColumns = @JoinColumn(name = "etiquette_id", foreignKey = @ForeignKey(name = "FK_produit_etiquette"))
    )
    private List<Etiquette> etiquettes;

    private boolean disponible = true;
}

