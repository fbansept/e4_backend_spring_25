package edu.fbansept.e4_backend_spring_25.controller;

import edu.fbansept.e4_backend_spring_25.dao.EtiquetteDao;
import edu.fbansept.e4_backend_spring_25.model.Etiquette;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EtiquetteController {

    EtiquetteDao etiquetteDao;

    @Autowired
    public EtiquetteController(EtiquetteDao etiquetteDao) {
        this.etiquetteDao = etiquetteDao;
    }

    @GetMapping("/etiquettes")
    public List<Etiquette> getEtiquettes() {

        return etiquetteDao.findAll();
    }

    @GetMapping("/etiquette/{id}")
    public ResponseEntity<Etiquette> getEtiquette(@PathVariable int id) {

        Optional<Etiquette> optionalEtiquette = etiquetteDao.findById(id);

        if (optionalEtiquette.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(optionalEtiquette.get(), HttpStatus.OK);

    }

    @PostMapping("/etiquette")
    public ResponseEntity<Etiquette> addEtiquette(@RequestBody @Valid Etiquette etiquette) {

        etiquette.setId(null);
//
//        if(etiquette.getId() != null) {
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }

        etiquetteDao.save(etiquette);

        return new ResponseEntity<>(etiquette, HttpStatus.CREATED);
    }

    @PutMapping("/etiquette/{id}")
    public ResponseEntity<Etiquette> updateEtiquette(@RequestBody @Valid Etiquette etiquette, @PathVariable int id) {

        etiquette.setId(id);

        etiquetteDao.save(etiquette);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/etiquette/{id}")
    public ResponseEntity<Etiquette> deleteEtiquette(@PathVariable int id) {

        Optional<Etiquette> optionalEtiquette = etiquetteDao.findById(id);

        if (optionalEtiquette.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        etiquetteDao.deleteById(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }


}
