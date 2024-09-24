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
        try {
            e.ajoutNote("Math", 10);
        } catch(Exception e){
            erreur = true ;
        }

        assertEquals(erreur,false);
    }

    @org.junit.jupiter.api.Test
    void calculerMoyenneMatiere() {
    }

    @org.junit.jupiter.api.Test
    void calculerMoyenneGenerale() {
    }
}