package edu.fbansept.e4_backend_spring_25.controller;

import com.fasterxml.jackson.annotation.JsonView;
import edu.fbansept.e4_backend_spring_25.dao.UtilisateurDao;
import edu.fbansept.e4_backend_spring_25.model.Utilisateur;
import edu.fbansept.e4_backend_spring_25.view.UtilisateurView;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UtilisateurController {

    UtilisateurDao utilisateurDao;

    @Autowired
    public UtilisateurController(UtilisateurDao utilisateurDao) {
        this.utilisateurDao = utilisateurDao;
    }

    @GetMapping("/utilisateurs")
    @JsonView(UtilisateurView.class)
    public List<Utilisateur> getUtilisateurs() {

        return utilisateurDao.findAll();
    }

    @GetMapping("/utilisateur/{id}")
    @JsonView(UtilisateurView.class)
    public ResponseEntity<Utilisateur> getUtilisateur(@PathVariable int id) {

        Optional<Utilisateur> optionalUtilisateur = utilisateurDao.findById(id);

        if (optionalUtilisateur.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(optionalUtilisateur.get(), HttpStatus.OK);

    }

    @PostMapping("/utilisateur")
    @JsonView(UtilisateurView.class)
    public ResponseEntity<Utilisateur> addUtilisateur(@RequestBody @Valid Utilisateur utilisateur) {

        utilisateur.setId(null);
//
//        if(utilisateur.getId() != null) {
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }

        utilisateurDao.save(utilisateur);

        return new ResponseEntity<>(utilisateur, HttpStatus.CREATED);
    }

    @PutMapping("/utilisateur/{id}")
    public ResponseEntity<Utilisateur> updateUtilisateur(@RequestBody @Valid Utilisateur utilisateur, @PathVariable int id) {

        utilisateur.setId(id);

        utilisateurDao.save(utilisateur);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/utilisateur/{id}")
    public ResponseEntity<Utilisateur> deleteUtilisateur(@PathVariable int id) {

        Optional<Utilisateur> optionalUtilisateur = utilisateurDao.findById(id);

        if (optionalUtilisateur.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Utilisateur utilisateurBdd = optionalUtilisateur.get();

        utilisateurBdd.setActif(false);

        utilisateurDao.save(utilisateurBdd);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }


}
