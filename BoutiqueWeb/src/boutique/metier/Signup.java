package boutique.metier;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.html.HtmlOutputLabel;

@ManagedBean(name = "beanSignup")
@SessionScoped
public class Signup {
    private String lastname;
    private String firstname;
    private Integer age;
    private String login;
    private String password;
    private short gender;
    private HtmlOutputLabel info;

    public Signup() {
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
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

    public short getGender() {
        return gender;
    }

    public void setGender(short gender) {
        this.gender = gender;
    }

    public HtmlOutputLabel getInfo() {
        return info;
    }

    public void setInfo(HtmlOutputLabel info) {
        this.info = info;
    }

    public String validate() {
        if (getLogin().equals("a") && getPassword().equals("a")) {
            info.setValue("Succès");
            info.setStyle("color: blue");
        } else {
            info.setValue("Echec");
            info.setStyle("color: red");
        }
        return "login?faces-redirect=true";
    }

    public String cancel() {
        return "login?faces-redirect=true";
    }

}
