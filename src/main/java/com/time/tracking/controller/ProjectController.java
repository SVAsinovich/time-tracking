package com.time.tracking.controller;

import com.time.tracking.model.Project;
import com.time.tracking.service.ProjectService;
import com.time.tracking.util.UtilController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/projects")
public class ProjectController {

    private final ProjectService projectService;

    @Autowired
    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Project> getProjectById(@RequestHeader(value = "Authorization") String auth, @PathVariable Long id) {
        if(UtilController.hasRoleAdmin(auth)) {
            return new ResponseEntity<>(projectService.get(id), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }

    @GetMapping
    public ResponseEntity<List<Project>> getAllProjects(@RequestHeader(value = "Authorization") String auth) {
        if(UtilController.hasRoleAdmin(auth)) {
            return new ResponseEntity<>(projectService.getAll(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }

    @PostMapping
    public ResponseEntity<Project> createProject(@RequestHeader(value = "Authorization") String auth, @RequestBody Project project) {
        if(UtilController.hasRoleAdmin(auth)) {
            return new ResponseEntity<>(projectService.create(project), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Project> updateProject(@RequestHeader(value = "Authorization") String auth, @RequestBody Project project) {
        if(UtilController.hasRoleAdmin(auth)) {
            return new ResponseEntity<>(projectService.update(project), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProject(@RequestHeader(value = "Authorization") String auth, @PathVariable Long id) {
        if(UtilController.hasRoleAdmin(auth)) {
            projectService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }
}
