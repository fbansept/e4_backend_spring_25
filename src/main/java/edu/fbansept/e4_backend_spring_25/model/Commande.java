package edu.fbansept.e4_backend_spring_25.model;

import com.fasterxml.jackson.annotation.JsonView;
import edu.fbansept.e4_backend_spring_25.view.CommandeView;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.List;


@Getter
@Setter
@Entity
@EntityListeners(AuditingEntityListener.class)//important pour @CreatedDate
public class Commande {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(CommandeView.class)
    private Integer id;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    @JsonView(CommandeView.class)
    private LocalDateTime date;

    @ManyToOne(optional = false)
    @JsonView(CommandeView.class)
    private Utilisateur utilisateur;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, columnDefinition = "ENUM('PANIER', 'A_VALIDER', 'ENVOYEE', 'ANNULEE', 'RECEPTIONNEE')")
    @JsonView(CommandeView.class)
    private Status status;

    @OneToMany(mappedBy = "commande")
    @JsonView(CommandeView.class)
    private List<LigneCommande> ligneCommandes;
}