package com.time.tracking.service;

import com.time.tracking.model.Project;
import com.time.tracking.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {

    private final ProjectRepository projectRepository;

    @Autowired
    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public Project create(Project project) {
        return projectRepository.save(project);
    }

    public Project update(Project project) {
        return projectRepository.save(project);
    }

    public void delete(Long id) {
        projectRepository.deleteById(id);
    }

    public Project get(Long id) {
        Optional<Project> user = projectRepository.findById(id);
        return user.orElse(null);
    }

    public List<Project> getAll() {
        return projectRepository.findAll();
    }
}
