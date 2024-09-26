import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

class EtudiantTest {

    private Etudiant e ;

    /**
     * Initialisation
     */
    @BeforeEach
    void setUp() {
        Identite i = new Identite("1234","Doe","John") ;
        Formation f = new Formation("BUT") ;
        f.ajouterMatiere("Math",2);
        f.ajouterMatiere("Anglais",1);
        f.ajouterMatiere("Info",3);
        e = new Etudiant(i,f) ;
    }

    /**
     * Test de la méthode d'ajout d'une note
     */
    @org.junit.jupiter.api.Test
    void ajoutNote() {

        boolean erreur = false ;
        try { e.ajoutNote("Math", 10); }
        catch(Exception e){ erreur = true ; }
        assertFalse(erreur);

        erreur = false ;
        try { e.ajoutNote("Anglais", 10); }
        catch(Exception e){ erreur = true ; }
        assertFalse(erreur);

        erreur = false ;
        try { e.ajoutNote("Math", -1); }
        catch(Exception e){ erreur = true ; }
        assertTrue(erreur);

        erreur = false ;
        try { e.ajoutNote("Math", 21); }
        catch(Exception e){ erreur = true ; }
        assertTrue(erreur);

        erreur = false ;
        try { e.ajoutNote("Test", 10); }
        catch(Exception e){ erreur = true ; }
        assertTrue(erreur);
    }

    /**
     * Test de la méthode de calcul de moyenne dans un matière
     */
    @org.junit.jupiter.api.Test
    void calculerMoyenneMatiere() {
        try {
            e.ajoutNote("Math",10);
            e.ajoutNote("Math",20);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }

        assertEquals(15,e.calculerMoyenneMatiere("Math"));
    }

    /**
     * Test de la méthode de calcul de moyenne générale
     */
    @org.junit.jupiter.api.Test
    void calculerMoyenneGenerale() {
        try {
            e.ajoutNote("Math",15);
            e.ajoutNote("Anglais",20);
            e.ajoutNote("Anglais",10);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        assertEquals(15,e.calculerMoyenneGenerale());
    }
}