import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projects")
public class ProjectControlleur {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private ClientService clientService; // Service pour obtenir les clients

    // Ajouter un nouveau projet
    @PostMapping("/add")
    public String addProject(@RequestBody Project project) {
        projectService.addProject(project);
        return "Projet ajouté avec succès";
    }

    // Obtenir tous les projets
    @GetMapping("/all")
    public List<Project> getAllProjects() {
        return projectService.getAllProjects();
    }

    // Obtenir tous les clients pour le champ de choix
    @GetMapping("/clients")
    public List<Client> getAllClients() {
        return clientService.getAllClients();
    }
}
