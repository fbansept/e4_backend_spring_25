package edu.fbansept.e4_backend_spring_25;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class E4BackendSpring25ApplicationTests {

    @Autowired
    private WebApplicationContext context;
    private MockMvc mvc;


    @BeforeEach
    public void setup() {
        mvc = MockMvcBuilders
                .webAppContextSetup(context)
                //.apply(springSecurity()) // a ajouter apres avoir mis spring security
                .build();
    }

    @Test
    public void getProduitExistant_doitRetournerUnStatut200() throws Exception {
        mvc.perform(get("/produit/1"))
                .andExpect(status().isOk());
    }

    @Test
    public void getProduitInexistant_doitRetournerUnStatut404() throws Exception {
        mvc.perform(get("/produit/99"))
                .andExpect(status().isNotFound());
    }

    @Test
    public void getUtilisateur_motDePasseUtilisateurInexistant() throws Exception {
        mvc.perform(get("/utilisateur/1"))
                .andExpect(jsonPath("$.password").doesNotExist());
    }

    @Test
    public void deleteProduit_doitRetournerUnStatut204() throws Exception {
        mvc.perform(delete("/produit/3"))
                .andExpect(status().isNoContent());
    }

}
