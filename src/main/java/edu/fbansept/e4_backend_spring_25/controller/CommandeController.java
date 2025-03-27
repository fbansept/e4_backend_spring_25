package edu.fbansept.e4_backend_spring_25.controller;

import com.fasterxml.jackson.annotation.JsonView;
import edu.fbansept.e4_backend_spring_25.dao.CommandeDao;
import edu.fbansept.e4_backend_spring_25.model.Commande;
import edu.fbansept.e4_backend_spring_25.model.Status;
import edu.fbansept.e4_backend_spring_25.view.CommandeView;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class CommandeController {

    CommandeDao commandeDao;

    @Autowired
    public CommandeController(CommandeDao commandeDao) {
        this.commandeDao = commandeDao;
    }

    @GetMapping("/commandes")
    @JsonView(CommandeView.class)
    public List<Commande> getCommandes() {

        return commandeDao.findAll();
    }

    @GetMapping("/commande/{id}")
    @JsonView(CommandeView.class)
    public ResponseEntity<Commande> getCommande(@PathVariable int id) {

        Optional<Commande> optionalCommande = commandeDao.findById(id);

        if (optionalCommande.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(optionalCommande.get(), HttpStatus.OK);

    }

    @PostMapping("/commande")
    @JsonView(CommandeView.class)
    public ResponseEntity<Commande> addCommande(@RequestBody @Valid Commande commande) {

        commande.setId(null);
//
//        if(commande.getId() != null) {
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }

        commande.setStatus(Status.PANIER);

        commandeDao.save(commande);

        return new ResponseEntity<>(commande, HttpStatus.CREATED);
    }

    @PutMapping("/commande/{id}")
    public ResponseEntity<Commande> updateCommande(@RequestBody @Valid Commande commande, @PathVariable int id) {

        commande.setId(id);

        commandeDao.save(commande);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/commande/{id}")
    public ResponseEntity<Commande> deleteCommande(@PathVariable int id) {

        Optional<Commande> optionalCommande = commandeDao.findById(id);

        if (optionalCommande.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        commandeDao.deleteById(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }


}
