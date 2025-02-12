package edu.fbansept.e4_backend_spring_25;

import edu.fbansept.e4_backend_spring_25.controller.ProduitController;
import edu.fbansept.e4_backend_spring_25.model.Produit;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ProduitControllerTests {

    @Test
    public void testGetProduitExistant_shouldReturnProduit() {

        ProduitController controller = new ProduitController(new FakeProduitDao());
        ResponseEntity<Produit> reponse = controller.getProduit(1);
        Assertions.assertEquals(HttpStatus.OK, reponse.getStatusCode());

    }

    @Test
    public void testGetProduitInexistant_shouldReturn404Error() {

        ProduitController controller = new ProduitController(new FakeProduitDao());
        ResponseEntity<Produit> reponse = controller.getProduit(2);
        Assertions.assertEquals(HttpStatus.NOT_FOUND, reponse.getStatusCode());

    }


}
