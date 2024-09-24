import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GroupeTest {
    private Groupe g;
    @BeforeEach
    void before(){
        Formation f = new Formation("test");
        g = new Groupe(f);
    }

    @Test
    void ajouterEtudiant() throws Exception {
        Identite i = new Identite("ABC", "Baudoin", "Mathieu");
        Formation f = new Formation("test");
        Etudiant e = new Etudiant(i, f);
        g.ajouterEtudiant(e);
    }

    @Test
    void supprimerEtudiant() {

    }

    @AfterEach
    void after(){

    }
}