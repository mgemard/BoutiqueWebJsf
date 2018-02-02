package boutique.metier;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "beanVille")
@SessionScoped
public class Ville {
    private String nom;
    private String codePostal;

    public Ville() {
        setNom("Rennes");
        setCodePostal("35000");
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String valider() {
        if (getCodePostal().equalsIgnoreCase("44000")) {
            setNom("Nantes");
        } else {
            setNom("Code postal inconnu");
        }
        return null;
    }
}
