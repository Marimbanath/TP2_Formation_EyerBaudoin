import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GroupeTest {
    private Groupe g;
    private Identite i1;
    private Etudiant e1;
    @BeforeEach
    void before(){
        i1 = new Identite("ABC", "Baudoin", "Mathieu");
        Formation f1 = new Formation("test");
        e1 = new Etudiant(i1, f1);
        g = new Groupe(f1);
    }

    @Test
    void ajouterEtudiant(){
        //Initialisations
        Etudiant e2 = new Etudiant(i1, new Formation("Guenego"));

        assertDoesNotThrow(() -> {g.ajouterEtudiant(e1);});

        assertThrows(Exception.class, () -> {g.ajouterEtudiant(e2);});
    }

    @Test
    void supprimerEtudiant(){
        assertDoesNotThrow(() -> {g.ajouterEtudiant(e1);});
        assertDoesNotThrow(() -> {g.supprimerEtudiant(e1);});
    }

    @AfterEach
    void after(){

    }
}