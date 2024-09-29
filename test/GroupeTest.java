import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class GroupeTest {
    private Groupe g;
    private Identite i1;
    private Identite i2;
    private Identite i3;
    private Etudiant e1;
    private Etudiant e2;
    private Etudiant e3;

    @BeforeEach
    void before(){
        i1 = new Identite("ABC", "Baudoin", "Mathieu");
        i2 = new Identite("BCD", "Eyer", "Nathan");
        i3 = new Identite("CDE", "Doe", "John");
        Formation f1 = new Formation("test");

        e1 = new Etudiant(i1, f1);
        e2 = new Etudiant(i2, f1);
        e3 = new Etudiant(i3, f1);

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

    @Test
    void triAlpha(){
        try {
            g.ajouterEtudiant(e1);
            g.ajouterEtudiant(e2);
            g.ajouterEtudiant(e3);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        g.triAlpha();
        assertEquals(g.toString(),"Baudoin Doe Eyer ") ;
    }

    @Test
    void triAntiAlpha(){
        try {
            g.ajouterEtudiant(e1);
            g.ajouterEtudiant(e2);
            g.ajouterEtudiant(e3);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        g.triAntiAlpha();
        assertEquals(g.toString(),"Eyer Doe Baudoin ") ;
    }

    @AfterEach
    void after(){

    }
}