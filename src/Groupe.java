import java.util.ArrayList;
import java.util.HashSet;

/**
 * Represente un groupe d'étudiant
 */
public class Groupe {

    /**
     * Liste des
     */
    private HashSet<Etudiant> groupe ;


    public Groupe(){
        groupe = new HashSet<Etudiant>() ;
    }

    public void ajouterEtudiant(Etudiant e){
        groupe.add(e);
    }

    public void supprimerEtudiant(Etudiant e){
        groupe.remove(e);
    }
}
