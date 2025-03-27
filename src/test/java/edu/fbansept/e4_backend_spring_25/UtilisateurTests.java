package edu.fbansept.e4_backend_spring_25;

import edu.fbansept.e4_backend_spring_25.model.Utilisateur;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class UtilisateurTests {

    private Validator validator;

    @BeforeEach
    public void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void createUserValid_shouldNotGenerateConstraintViolation() {

        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setEmail("a@a.com");
        utilisateur.setPassword("abc");

        Set<ConstraintViolation<Utilisateur>> violations = validator.validate(utilisateur);
        assertTrue(violations.isEmpty());

    }

    @Test
    public void createUserWithInvalidEmail_shouldGenerateConstraintViolation() {

        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setEmail("a@.com");
        utilisateur.setPassword("abc");

        Set<ConstraintViolation<Utilisateur>> violations = validator.validate(utilisateur);
        assertTrue(violations.isEmpty());

    }


}
