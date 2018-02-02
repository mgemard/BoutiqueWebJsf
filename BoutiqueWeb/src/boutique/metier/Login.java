package boutique.metier;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import boutique.pojo.Client;

@ManagedBean(name = "beanLogin")
@SessionScoped
public class Login {
    private String login;
    private String password;
    private HtmlOutputLabel info;

    public Login() {
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public HtmlOutputLabel getInfo() {
        return info;
    }

    public void setInfo(HtmlOutputLabel info) {
        this.info = info;
    }

    public String validate(ClientList clientList) {
        // pour retrouver la liste des clients dans l'espace Application
        // ClientList clientList =
        // FacesContext.getCurrentInstance().getExternalContext().getApplicationMap().get("clientList");

        Client clientTrouve = null;

        if (clientList != null) {
            clientTrouve = clientList.checkAuthentication(login, password);

        }

        if (clientTrouve != null) {
            info.setValue("Succès");
            info.setStyle("color: blue");

            // on place le client trouvé dans l'espace de session
            // il sera associé à la clé "clientAuthentifie"
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("clientAuthentifie",
                    clientTrouve);

            return "visuCatalogue";
        } else {
            info.setValue("Echec");
            info.setStyle("color: red");
        }
        return null;

    }

    public String login() {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        session.invalidate();
        return "login";
    }

}
