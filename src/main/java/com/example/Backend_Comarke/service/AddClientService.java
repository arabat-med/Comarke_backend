import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

public class AddClientService{

    // Simulation d'une base de données en mémoire
    private List<Client> clients = new ArrayList<>();

    // Ajouter un nouveau client
    public void addClient(Client client) {
        clients.add(client);
    }

    // Obtenir tous les clients
    public List<Client> getAllClients() {
        return clients;
    }

    // Obtenir un client par email
    public Client getClientByEmail(String email) {
        return clients.stream()
                .filter(client -> client.getEmail().equals(email))
                .findFirst()
                .orElse(null);
    }

    // Mettre à jour les informations d'un client
    public void updateClient(String email, Client updatedClient) {
        Client client = getClientByEmail(email);
        if (client != null) {
            client.setClientName(updatedClient.getClientName());
            client.setEmail(updatedClient.getEmail());
            client.setPassword(updatedClient.getPassword());
            client.setPhone(updatedClient.getPhone());
            client.setCompanyName(updatedClient.getCompanyName());
            client.setCompanyType(updatedClient.getCompanyType());
        }
    }

    // Supprimer un client
    public void deleteClient(String email) {
        clients.removeIf(client -> client.getEmail().equals(email));
    }
}
