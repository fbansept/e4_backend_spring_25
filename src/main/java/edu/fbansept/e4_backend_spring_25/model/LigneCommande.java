package edu.fbansept.e4_backend_spring_25.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import edu.fbansept.e4_backend_spring_25.view.CommandeView;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
public class LigneCommande {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(CommandeView.class)
    private Integer id;

    @Min(value = 0, message = "La quantité doit être positive")
    @JsonView(CommandeView.class)
    private int quantite;

    @Column(nullable = false)
    @JsonView(CommandeView.class)
    private float prixDeVente;

    @ManyToOne(optional = false)
    @JsonView(CommandeView.class)
    private Produit produit;
    
    @ManyToOne(optional = false)
    private Commande commande;
}