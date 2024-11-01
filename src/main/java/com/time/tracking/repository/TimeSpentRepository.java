package com.time.tracking.repository;

import com.time.tracking.model.TimeSpent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TimeSpentRepository extends JpaRepository<TimeSpent, Long> {

    List<TimeSpent> findAllByProjectId(Long projectId);

    List<TimeSpent> findAllByUserId(Long userId);

    List<TimeSpent> findAllByUserIdAndProjectId(Long userId, Long projectId);
}
