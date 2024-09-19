import java.util.HashMap;

/**
 * Represente une formation qu'un étudiant suit
 */
public class Formation {

    /**
     * Intitulé de la formation
     */
    private String id ;

    /**
     * Tableau des matieres et de leurs coefficients respectifs dans la formation
     */
    private HashMap<String,Float> matieres ;

    /**
     * Constructeur
     * @param pId
     */
    public Formation(String pId){
        this.id = pId ;
        this.matieres = new HashMap<String,Float>() ;
    }

    /**
     * Ajoute une matiere si elle n'existe pas déja ou change le coeff si elle existe
     * @param pMatiere
     * @param pCoeff
     */
    public void ajouterMatiere(String pMatiere,float pCoeff){
        if(matieres.containsKey(pMatiere)){
            matieres.replace(pMatiere,pCoeff);
        }

        matieres.put(pMatiere, pCoeff);
    }

    /**
     * Supprime une matiere
     * @param pMatiere
     */
    public void supprimerMatiere(String pMatiere){
        matieres.remove(pMatiere) ;
    }

    /**
     * Retourne le coefficient d'une matiere de la formation, -1 si la matiere n'existe pas
     * @param pMatiere
     * @return
     */
    public float getCoeff(String pMatiere){
        if(matieres.containsKey(pMatiere)) {
            return matieres.get(pMatiere);
        } else {
            return -1 ;
        }
    }

    /**
     * Verifie si la matiere existe dans la formation
     * @param pMatiere
     * @return
     */
    public boolean matiereExiste(String pMatiere){
        return matieres.containsKey(pMatiere) ;
    }
}
