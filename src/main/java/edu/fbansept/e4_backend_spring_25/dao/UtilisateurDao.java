package edu.fbansept.e4_backend_spring_25.dao;

import edu.fbansept.e4_backend_spring_25.model.Produit;
import edu.fbansept.e4_backend_spring_25.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilisateurDao extends JpaRepository<Utilisateur, Integer> {
    
}
