package boutique.metier;

import java.util.ArrayList;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.model.ListDataModel;

@ManagedBean
@ApplicationScoped
public class Catalogue extends ListDataModel<Article> {

    public Catalogue() {
        // création de 10 articles placés dans une ArrayList
        ArrayList<Article> liste = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Article art = new Article();
            art.setNom("ART" + i);
            art.setDescription("Description" + i);
            art.setPrix(i * 12.34);

            liste.add(art);
        }
        
        // on alimente le catalogue (DataModel) avec la liste.
        this.setWrappedData(liste);
    }

}
