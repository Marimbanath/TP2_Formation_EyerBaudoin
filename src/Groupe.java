import java.security.cert.CertificateRevokedException;
import java.util.ArrayList;
import java.util.HashSet;

/**
 * Represente un groupe d'etudiant
 */
public class Groupe {

    /**
     * Liste des etudiants d'un groupe
     */
    private HashSet<Etudiant> groupe ;
    private static Formation formation;

    /**
     * Crée une groupe d'etudiant
     * @param f formation du groupe
     */
    public Groupe(Formation f){
        groupe = new HashSet<Etudiant>() ;
        formation = f;
    }

    /**
     * Permet d'ajouter un etudiant de la meme formation
     * @param e
     */
    public void ajouterEtudiant(Etudiant e) throws Exception {
        if(e.getFormation().getId().equals(formation.getId())){
            groupe.add(e);
        }else{
            throw new Exception("Formation non correspondante");
        }
    }

    /**
     * Permet de supprimer un Etudiant du groupe
     * @param e Etudiant à retirer
     */
    public void supprimerEtudiant(Etudiant e){
        groupe.remove(e);
    }
}
