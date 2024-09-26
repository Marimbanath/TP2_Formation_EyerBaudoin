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
    private final HashSet<Etudiant> groupe ;
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
     * @param e Etudiant à ajouter
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

    public float calculerMoyenneMatiere(String matiere){
        float moy = 0; int length = 0;
        if(formation.matiereExiste(matiere)){
            for(Etudiant e: groupe){
                moy += e.calculerMoyenneMatiere(matiere);
                length++;
            }
            return moy/length;
        }else{
            return -1;
        }
    }

    /**
     * Calcule la moyenne générale d'un Etudiant
     * @return moyenne générale
     */
    public float calculerMoyenneGenerale(){
        float moy = 0; int length = 0;
        for(Etudiant e:groupe){
            moy += e.calculerMoyenneGenerale();
            length++;
        }
        return moy/length;
    }

}
