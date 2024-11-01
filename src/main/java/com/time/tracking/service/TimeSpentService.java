package com.time.tracking.service;

import com.time.tracking.model.TimeSpent;
import com.time.tracking.repository.TimeSpentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TimeSpentService {

    private final TimeSpentRepository timeSpentRepository;

    @Autowired
    public TimeSpentService(TimeSpentRepository timeSpentRepository) {
        this.timeSpentRepository = timeSpentRepository;
    }

    public TimeSpent create(TimeSpent timeSpent) {
        return timeSpentRepository.save(timeSpent);
    }

    public TimeSpent update(TimeSpent timeSpent) {
        return timeSpentRepository.save(timeSpent);
    }

    public void delete(Long id) {
        timeSpentRepository.deleteById(id);
    }

    public TimeSpent get(Long id) {
        Optional<TimeSpent> user = timeSpentRepository.findById(id);
        return user.orElse(null);
    }

    public List<TimeSpent> getAll() {
        return timeSpentRepository.findAll();
    }

    public List<TimeSpent> getAllByProjectId(Long projectId) {
        return timeSpentRepository.findAllByProjectId(projectId);
    }

    public List<TimeSpent> getAllByUserId(Long userId) {
        return timeSpentRepository.findAllByUserId(userId);
    }

    public List<TimeSpent> getAllByUserIdAndProjectId(Long userId, Long projectId) {
        return timeSpentRepository.findAllByUserIdAndProjectId(userId, projectId);
    }
}
