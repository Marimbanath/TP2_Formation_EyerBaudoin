import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class FormationTest {
    private Formation formation;
    @BeforeEach
    void before(){
        formation = new Formation("Informatique");
    }

    @Test
    void ajouterMatiere() {
        //Initialisation
        formation.ajouterMatiere("QDev", 10);
        formation.ajouterMatiere("Archi", -1000);
        //Valeurs à tester
        float test1 = formation.getMatieres().get("QDev");
        float test2 = formation.getMatieres().get("Archi");
        //Tests
        assertEquals(10, test1);
        assertEquals(0, test2);
    }

    @Test
    void supprimerMatiere() {
    }

    @Test
    void getCoeff() {
    }

    @Test
    void matiereExiste() {
    }

    @AfterEach
    void after(){

    }
}