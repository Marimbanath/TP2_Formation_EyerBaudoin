/**
 * Definit l'identite d'un Etudiant
 */
public class Identite {
    /**
     * Description d'un Etudiant
     */
    private String nip, nom, prenom;

    /**
     * Construit un Etudiant
     * @param nip numero d'identification personnel
     * @param nom nom
     * @param prenom prenom
     */
    public Identite(String nip, String nom, String prenom) {
        this.nip = nip;
        this.nom = nom;
        this.prenom = prenom;
    }

    /**
     * Acces au nip
     * @return nip
     */
    public String getNip() {
        return nip;
    }

    /**
     * Acces au nom
     * @return nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * Acces au prenom
     * @return prenom
     */
    public String getPrenom() {
        return prenom;
    }
}
