package edu.fbansept.e4_backend_spring_25.controller;

import edu.fbansept.e4_backend_spring_25.dao.ProduitDao;
import edu.fbansept.e4_backend_spring_25.model.Produit;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class ProduitController {

    ProduitDao produitDao;

    @Autowired
    public ProduitController(ProduitDao produitDao) {
        this.produitDao = produitDao;
    }

    @GetMapping("/produits")
    public List<Produit> getProduits() {

        return produitDao.findAllByDisponible(true);
    }

    @GetMapping("/produit/{id}")
    public ResponseEntity<Produit> getProduit(@PathVariable int id) {

        Optional<Produit> optionalProduit = produitDao.findById(id);

        if (optionalProduit.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(optionalProduit.get(), HttpStatus.OK);

    }

    @PostMapping("/produit")
    public ResponseEntity<Produit> addProduit(@RequestBody @Valid Produit produit) {

        produit.setId(null);

        produit.setDisponible(true);

        produitDao.save(produit);

        return new ResponseEntity<>(produit, HttpStatus.CREATED);
    }

    @PutMapping("/produit/{id}")
    public ResponseEntity<Produit> updateProduit(@RequestBody @Valid Produit produit, @PathVariable int id) {

        produit.setId(id);

        produitDao.save(produit);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/produit/{id}")
    public ResponseEntity<Produit> deleteProduit(@PathVariable int id) {

        Optional<Produit> optionalProduit = produitDao.findById(id);

        if (optionalProduit.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        produitDao.deleteById(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PatchMapping("/produit/rendre-indisponible/{id}")
    public ResponseEntity<Produit> rendreProduitIndisponible(@PathVariable int id) {

        Optional<Produit> optionalProduit = produitDao.findById(id);

        if (optionalProduit.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Produit produitBdd = optionalProduit.get();

        if (!produitBdd.isDisponible()) {
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        }

        produitBdd.setDisponible(false);

        produitDao.save(produitBdd);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
