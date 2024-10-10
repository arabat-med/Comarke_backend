import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
public class AddClientControlleur {

    @Autowired
    private ClientService clientService;

    // Ajouter un nouveau client
    @PostMapping("/add")
    public String addClient(@RequestBody Client client) {
        clientService.addClient(client);
        return "Client ajouté avec succès";
    }

    // Obtenir tous les clients
    @GetMapping("/all")
    public List<Client> getAllClients() {
        return clientService.getAllClients();
    }

    // Obtenir un client par email
    @GetMapping("/{email}")
    public Client getClientByEmail(@PathVariable String email) {
        return clientService.getClientByEmail(email);
    }

    // Mettre à jour un client par email
    @PutMapping("/update/{email}")
    public String updateClient(@PathVariable String email, @RequestBody Client updatedClient) {
        clientService.updateClient(email, updatedClient);
        return "Client mis à jour avec succès";
    }

    // Supprimer un client par email
    @DeleteMapping("/delete/{email}")
    public String deleteClient(@PathVariable String email) {
        clientService.deleteClient(email);
        return "Client supprimé avec succès";
    }
}
