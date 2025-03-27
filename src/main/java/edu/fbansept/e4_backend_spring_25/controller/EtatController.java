package edu.fbansept.e4_backend_spring_25.controller;

import edu.fbansept.e4_backend_spring_25.dao.EtatDao;
import edu.fbansept.e4_backend_spring_25.model.Etat;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class EtatController {

    EtatDao etatDao;

    @Autowired
    public EtatController(EtatDao etatDao) {
        this.etatDao = etatDao;
    }

    @GetMapping("/etats")
    public List<Etat> getEtats() {

        return etatDao.findAll();
    }

    @GetMapping("/etat/{id}")
    public ResponseEntity<Etat> getEtat(@PathVariable int id) {

        Optional<Etat> optionalEtat = etatDao.findById(id);

        if (optionalEtat.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(optionalEtat.get(), HttpStatus.OK);

    }

    @PostMapping("/etat")
    public ResponseEntity<Etat> addEtat(@RequestBody @Valid Etat etat) {

        etat.setId(null);
//
//        if(etat.getId() != null) {
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }

        etatDao.save(etat);

        return new ResponseEntity<>(etat, HttpStatus.CREATED);
    }

    @PutMapping("/etat/{id}")
    public ResponseEntity<Etat> updateEtat(@RequestBody @Valid Etat etat, @PathVariable int id) {

        etat.setId(id);

        etatDao.save(etat);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/etat/{id}")
    public ResponseEntity<Etat> deleteEtat(@PathVariable int id) {

        Optional<Etat> optionalEtat = etatDao.findById(id);

        if (optionalEtat.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        etatDao.deleteById(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }


}
