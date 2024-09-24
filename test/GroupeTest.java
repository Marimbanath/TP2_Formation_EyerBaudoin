import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GroupeTest {
    private Groupe g;
    private Identite i1;
    private Formation f1;
    private Etudiant e1;
    @BeforeEach
    void before(){
        i1 = new Identite("ABC", "Baudoin", "Mathieu");
        f1 = new Formation("test");
        f1.ajouterMatiere("qdev", 3);
        f1.ajouterMatiere("test", 5);
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

    @Test
    void calculerMoyenneMatiere() throws Exception {
        Etudiant e2 = new Etudiant(i1, f1);
        Etudiant e3 = new Etudiant(i1, f1);
        Etudiant e4 = new Etudiant(i1, f1);

        e1.ajoutNote("qdev", 5);
        e2.ajoutNote("qdev", 10);
        e3.ajoutNote("qdev", 15);
        e4.ajoutNote("qdev", 20);
        e4.ajoutNote("test", 0);

        g.ajouterEtudiant(e1);
        g.ajouterEtudiant(e2);
        g.ajouterEtudiant(e3);
        g.ajouterEtudiant(e4);

        assertEquals(12.5, g.calculerMoyenneMatiere("qdev"));
    }

    @Test
    void calculerMoyenneGenerale() throws Exception {
        Etudiant e2 = new Etudiant(i1, f1);
        Etudiant e3 = new Etudiant(i1, f1);
        Etudiant e4 = new Etudiant(i1, f1);

        e1.ajoutNote("qdev", 5);
        e2.ajoutNote("qdev", 10);
        e3.ajoutNote("qdev", 15);
        e4.ajoutNote("qdev", 20);
        e4.ajoutNote("test", 0);

        g.ajouterEtudiant(e1);
        g.ajouterEtudiant(e2);
        g.ajouterEtudiant(e3);
        g.ajouterEtudiant(e4);

        assertEquals(9.375, g.calculerMoyenneGenerale());
    }

    @AfterEach
    void after(){

    }
}