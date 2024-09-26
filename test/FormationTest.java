import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FormationTest {
    private Formation formation;

    /**
     * Initialisations
     */
    @BeforeEach
    void before(){
        formation = new Formation("Informatique");
        formation.ajouterMatiere("QDev", 10);
        formation.ajouterMatiere("Archi", -1000);
    }

    /**
     * Test de la méthode d'ajout d'une matière
     */
    @Test
    void ajouterMatiere() {
        //Valeurs à tester
        float test1 = formation.getMatieres().get("QDev");
        float test2 = formation.getMatieres().get("Archi");

        //Tests
        assertEquals(10, test1);
        assertEquals(0, test2);
    }

    /**
     * Test de la méthode de suppression d'une matière
     */
    @Test
    void supprimerMatiere() {
        //Initialisation
        formation.supprimerMatiere("QDev");
        formation.supprimerMatiere("Archi");

        //Tests
        assertFalse(formation.matiereExiste("Qdev"));
        assertFalse(formation.matiereExiste("Archi"));
    }

    /**
     * Test de l'accesseur
     */
    @Test
    void getCoeff() {
        formation.supprimerMatiere("QDev");
        assertEquals(-1, formation.getCoeff("QDev"));
        formation.ajouterMatiere("QDev", 10);
        assertEquals(10, formation.getCoeff("QDev"));
    }

    /**
     * Test de la méthode de vérification de l'existence d'une matiere
     */
    @Test
    void matiereExiste() {
        //Initialisation
        formation.ajouterMatiere("QDev", 10);

        assertTrue(formation.matiereExiste("QDev"));
        assertFalse(formation.matiereExiste("Pierre-André"));
    }
}