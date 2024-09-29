import java.util.ArrayList;
import java.util.List;

/**
 * Represente un groupe d'etudiant
 */
public class Groupe {

    /**
     * Liste des etudiants d'un groupe
     */
    private List<Etudiant> groupe ;
    private static Formation formation;

    /**
     * Crée une groupe d'etudiant
     * @param f formation du groupe
     */
    public Groupe(Formation f){
        groupe = new ArrayList<Etudiant>() ;
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

    /**
     * Trie les étudiant du groupe dans l'ordre alphabétique
     */
    public void triAlpha(){
        Etudiant tmp ;

        for (int i = 1; i < groupe.size(); i++) {
            tmp = groupe.get(i);
            int j = i - 1;
            while ((j >= 0) && (groupe.get(j).getNom().compareTo(tmp.getNom()))>0) {
                groupe.set(j + 1,groupe.get(j));
                j = j - 1;
            }
            groupe.set(j + 1,tmp);
        }
    }

    /**
     * Trie les étudiants dans l'ordre anti-alphabétique
     */
    public void triAntiAlpha(){
        Etudiant tmp ;

        for (int i = 1; i < groupe.size(); i++) {
            tmp = groupe.get(i);
            int j = i - 1;
            while ((j >= 0) && (groupe.get(j).getNom().compareTo(tmp.getNom()))<=0) {
                groupe.set(j + 1,groupe.get(j));
                j = j - 1;
            }
            groupe.set(j + 1,tmp);
        }
    }

    public String toString(){
        String ret = "";
        for(int i = 0 ; i < groupe.size() ; i++){
            ret += groupe.get(i).getNom() + " ";
        }
        return ret ;
    }
}
