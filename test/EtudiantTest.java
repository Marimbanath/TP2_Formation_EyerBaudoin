import java.text.Normalizer;

import static org.junit.jupiter.api.Assertions.*;

class EtudiantTest {

    Etudiant e ;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        Identite i = new Identite("1234","Doe","John") ;
        Formation f = new Formation("BUT") ;
        f.ajouterMatiere("Math",2);
        f.ajouterMatiere("Anglais",1);
        f.ajouterMatiere("Info",3);
        e = new Etudiant(i,f) ;
    }

    @org.junit.jupiter.api.Test
    void ajoutNote() {

        boolean erreur = false ;
        try { e.ajoutNote("Math", 10); }
        catch(Exception e){ erreur = true ; }
        assertEquals(false,erreur);

        erreur = false ;
        try { e.ajoutNote("Anglais", 10); }
        catch(Exception e){ erreur = true ; }
        assertEquals(false,erreur);

        erreur = false ;
        try { e.ajoutNote("Math", -1); }
        catch(Exception e){ erreur = true ; }
        assertEquals(true,erreur);

        erreur = false ;
        try { e.ajoutNote("Math", 21); }
        catch(Exception e){ erreur = true ; }
        assertEquals(true,erreur);

        erreur = false ;
        try { e.ajoutNote("Test", 10); }
        catch(Exception e){ erreur = true ; }
        assertEquals(true,erreur);
    }

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