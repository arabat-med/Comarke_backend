import java.util.ArrayList;
import java.util.List;

public class ProjectService {

    // Simulation d'une base de données en mémoire
    private List<Project> projects = new ArrayList<>();

    // Ajouter un nouveau projet
    public void addProject(Project project) {
        projects.add(project);
    }

    // Obtenir tous les projets
    public List<Project> getAllProjects() {
        return projects;
    }
}
