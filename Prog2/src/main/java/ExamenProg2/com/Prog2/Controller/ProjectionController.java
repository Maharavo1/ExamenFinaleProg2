package ExamenProg2.com.Prog2.Controller;

import ExamenProg2.com.Prog2.Service.ProjectionService;
import ExamenProg2.com.Prog2.model.projection;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProjectionController {
    private ProjectionService projectionService;

    public ProjectionController(ProjectionService projectionService) {
        this.projectionService = projectionService;
    }

    @GetMapping("projection")
    public List<projection> getAllProjections() {
        return projectionService.getAllProjections();
    }

    @PostMapping("/projectionInsert")
    public void insertProjection(@RequestBody projection toInsert) {
        projectionService.insertProjections(toInsert);
    }

    @GetMapping("/projectionId/{id}")
    public projection getProjectionById(@PathVariable int id) {
        return projectionService.getIdProjections(id);
    }

    @PutMapping("/projectionUpdate/{id}")
    public projection updateProjection(@PathVariable int id, @RequestBody projection toUpdate) {
        return projectionService.updateProjections(id, toUpdate);
    }

    @DeleteMapping("/projectionDelete/{id}")
    public List<projection> deleteProjection(@PathVariable int id) {
        return projectionService.deleteProjections(id);
    }
}
