package ExamenProg2.com.Prog2.Repository;


import ExamenProg2.com.Prog2.model.projection;
import org.springframework.stereotype.Service;

import java.util.List;
@Repository
public abstract class ProjectionDAO {
    public abstract List<projection> getAllProjection();
    public abstract  void insertProjection(projection toInsert);
    public abstract projection getIdProjection(int id);
    public abstract projection updateProjection(int id, projection toUpdate);
    public abstract List<projection> deleteProjection(int id);
}
