/**
 * Définit l'identité d'un étudiant
 */
public class Identite {
    /**
     * Description d'un Etudiant
     */
    private String nip, nom, prenom;

    /**
     * Constructeur d'un Etudiant
     * @param nip numéro d'identification personnel
     * @param nom nom de l'Etudiant
     * @param prenom prenom de l'Etudiant
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