package boutique.metier;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import boutique.pojo.Client;


@ManagedBean
@ApplicationScoped
public class ClientList {

    private List<Client> clients;
    
    
    public ClientList() {
        clients = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Client client = new Client();
            client.setLastname("NOM"+i);
            client.setFirstname("Prénom"+i);
            client.setLogin("login"+i);
            client.setPassword("password"+i);
            
            clients.add(client);
        }
    }

    /**
     * Retourne le client correspondant aux log et pwd founis is ce client existe.
     * @param log
     * @param pwd
     * @return
     */
    public Client checkAuthentication(String log, String pwd) {
        
        Client clientTrouve = null;
        for (Client client : clients) {
            if(client.getLogin().equalsIgnoreCase(log) && client.getPassword().equals(pwd)) {
                clientTrouve = client;
                break;
            }
        }
        return clientTrouve;
    }

    public List<Client> clientslist() {
        return clients;
    }
    
}
