package edu.fbansept.e4_backend_spring_25.controller;

import edu.fbansept.e4_backend_spring_25.dao.UtilisateurDao;
import edu.fbansept.e4_backend_spring_25.model.Utilisateur;
import edu.fbansept.e4_backend_spring_25.security.AppUserDetails;
import edu.fbansept.e4_backend_spring_25.security.JwtUtils;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class ConnexionController {

    UtilisateurDao utilisateurDao;

    @Autowired
    BCryptPasswordEncoder encoder;

    @Autowired
    AuthenticationProvider authProvider;

    @Autowired
    JwtUtils jwtUtils;

    @Autowired
    public ConnexionController(UtilisateurDao utilisateurDao) {
        this.utilisateurDao = utilisateurDao;
    }

    @PostMapping("/inscription")
    public ResponseEntity<Utilisateur> inscription(@RequestBody @Valid Utilisateur utilisateur) {

        utilisateur.setPassword(encoder.encode(utilisateur.getPassword()));
        utilisateur.setAdministrateur(false);
        utilisateur.setActif(true);

        utilisateurDao.save(utilisateur);

        return new ResponseEntity<>(utilisateur, HttpStatus.CREATED);

    }

    @PostMapping("/connexion")
    public ResponseEntity<String> connexion(@RequestBody @Valid Utilisateur utilisateur) {

        try {
            AppUserDetails userDetails = (AppUserDetails) authProvider.authenticate(
                            new UsernamePasswordAuthenticationToken(
                                    utilisateur.getEmail(),
                                    utilisateur.getPassword()))
                    .getPrincipal();

            return new ResponseEntity<>(jwtUtils.generateJwt(userDetails), HttpStatus.OK);

        } catch (AuthenticationException e) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

}
