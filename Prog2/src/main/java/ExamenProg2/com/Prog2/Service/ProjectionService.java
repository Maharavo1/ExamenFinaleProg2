package ExamenProg2.com.Prog2.Service;

import ExamenProg2.com.Prog2.Repository.ProjectionDAO;
import ExamenProg2.com.Prog2.model.projection;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectionService {
    private ProjectionDAO projectionDAO;


    public ProjectionService(ProjectionDAO projectionDAO) {
        this.projectionDAO = projectionDAO;
    }

    public List<projection> getAllProjections() {
        return projectionDAO.getAllProjection();
    }

    public void insertProjections(projection toInsert) {
      projectionDAO.insertProjection(toInsert);
    }

    public projection getIdProjections(int id) {
      return projectionDAO.getIdProjection(id);
    }

    public projection updateProjections(int id, projection toUpdate) {
       return projectionDAO.updateProjection(id ,toUpdate);
    }

    public List<projection> deleteProjections(int id) {
        return projectionDAO.deleteProjection(id);
    }
}
