package boutique.metier;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.html.HtmlInputText;
import javax.faces.event.AjaxBehaviorEvent;

@ManagedBean(name = "ajoutArticleBean")
@RequestScoped
public class AjoutArticleBean {
    private String nom;
    private String erreurNom;
    private String description;
    private String erreurDescription;
    private Double prix;
    private String erreurPrix;

    public AjoutArticleBean() {
        setErreurNom("");
        setErreurDescription("");
        setErreurPrix("");
    }

    public String getErreurNom() {
        return erreurNom;
    }

    public void setErreurNom(String erreurNom) {
        this.erreurNom = erreurNom;
    }

    public String getErreurDescription() {
        return erreurDescription;
    }

    public void setErreurDescription(String erreurDescription) {
        this.erreurDescription = erreurDescription;
    }

    public String getErreurPrix() {
        return erreurPrix;
    }

    public void setErreurPrix(String erreurPrix) {
        this.erreurPrix = erreurPrix;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrix() {
        return prix;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }

    public String enregistrer() {
        // Création et ajout d'un article dans le catalogue.
        return null;
    }

    public void verification(AjaxBehaviorEvent event) {
        // On vérifie que le nom saisi fait au max 10 caractères.
        // On informe l'internaute si besoin.
        System.out.println("nom: " + getNom());
        if (getNom().length() >= 10) {
            setErreurNom("Il y a trop de caractères");
        } else {
            setErreurNom("");
        }
    }

    public void verifierPrix(AjaxBehaviorEvent event) {
        // le champ de saisie du prix doit devenir rouge si le prix est négatif.
        // ou si le champ de saisie contient une chaine non numérique.
        HtmlInputText composantSaisie = (HtmlInputText) event.getSource();

        // On vérifie que le prix saisi est numérique
        Double prix;

        try {
            prix = new Double(getPrix());
            if (prix < 0) {
                composantSaisie.setStyle("background-color:red");
                System.out.println("prix inferieur à 0");
            } else {

                System.out.println("prix supérieur à 0");
            }
        } catch (ClassCastException ccs) {
            System.out.println("cannot cast to number");
        }

    }
}
