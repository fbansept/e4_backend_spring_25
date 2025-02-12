package edu.fbansept.e4_backend_spring_25;

import edu.fbansept.e4_backend_spring_25.model.Etat;
import edu.fbansept.e4_backend_spring_25.model.Produit;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

public class ProduitTests {

    private Validator validator;

    @BeforeEach
    public void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void testValidProduit() {
        Produit produit = new Produit();
        produit.setNom("Nom valide");
        produit.setCode("CODE123");
        produit.setPrix(10.0f);
        produit.setEtat(new Etat());

        Set<ConstraintViolation<Produit>> violations = validator.validate(produit);
        Assertions.assertTrue(violations.isEmpty());
    }

    @Test
    public void creationProduitSansNom_shouldReturnValidationError() {

        Produit produit = new Produit();
        produit.setNom(null);
        produit.setCode("CODE123");
        produit.setPrix(10.0f);
        produit.setEtat(new Etat());

        Set<ConstraintViolation<Produit>> violations = validator.validate(produit);
        Assertions.assertFalse(violations.isEmpty());
        Assertions.assertEquals(1, violations.size());
        Assertions.assertEquals("Le nom ne peut être vide, null ou ne comporter que des espaces", violations.iterator().next().getMessage());
    }

    @Test
    public void creationProduitAvecNomVide_shouldReturnValidationError() {

        Produit produit = new Produit();
        produit.setNom(" ");
        produit.setCode("CODE123");
        produit.setPrix(10.0f);
        produit.setEtat(new Etat());

        Set<ConstraintViolation<Produit>> violations = validator.validate(produit);
        Assertions.assertFalse(violations.isEmpty());
        Assertions.assertEquals(1, violations.size());
        Assertions.assertEquals("Le nom ne peut être vide, null ou ne comporter que des espaces", violations.iterator().next().getMessage());
    }


}
