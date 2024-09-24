import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

/**
 * Definit un etudiant
 */
public class Etudiant {
    //Descriptions d'un Etudiant
    private Identite identite;
    private Formation formation;
    private TreeMap<String,List<Float>> resultats;

    /**
     * Construit un Etudiant
     * @param identite identite
     * @param formation formation
     */
    public Etudiant(Identite identite, Formation formation) {
        this.identite = identite;
        this.formation = formation;
        this.resultats = new TreeMap<String, List<Float>>();
    }

    /**
     * Ajoute une note à une matière si elle existe
     * @param matiere matiere recherchée
     * @param pNote note à ajouter
     */
    public void ajoutNote(String matiere, float pNote) throws Exception {

        Float note = Float.valueOf(pNote) ;
        //Verifie que la matiere existe dans la formation
        if(!this.formation.matiereExiste(matiere)){
            throw new Exception("Matière inexistante dans la formation") ;
        //Verifie que 0<note<20
        }else if(note>=0 && note<=20){
            //Agit en fonciton de la presence ou non de la matiere
            if(this.resultats.containsKey(matiere)){
                this.resultats.get(matiere).add(note);
            }else{
                List<Float> l = new ArrayList<Float>();
                l.add(note);
                this.resultats.put(matiere,l);
            }
        //Erreur de note
        }else{
            throw new Exception("Note à l'exterieur des bornes");
        }
    }

    /**
     * Renvoie la moyenne de l'Etudiant dans une certaine matiere
     * @param matiere matiere recherchee
     * @return moyenne
     */
    public float calculerMoyenneMatiere(String matiere){
        if(!this.formation.matiereExiste(matiere)){
            return -1 ;
        }
        if(this.resultats.containsKey(matiere)){
            float res = 0;
            int nb = 0;
            for(float f:this.resultats.get(matiere)){
                res += f;
                nb++;
            }
            return res/nb;
        }else{
            return -1;
        }
    }

    public float calculerMoyenneGenerale(){
        if(this.resultats.isEmpty()) {
            return -1;
        }

        float sommeCoeff = 0;
        float sommeResultat = 0;
        float coeffMatiere ;

        for(String matiere:this.resultats.keySet()){
            coeffMatiere = this.formation.getCoeff(matiere) ;
            sommeCoeff += coeffMatiere ;
            sommeResultat += calculerMoyenneMatiere(matiere) * coeffMatiere ;
        }
        return sommeResultat / sommeCoeff;
    }

    public Formation getFormation() {
        return formation;
    }
}