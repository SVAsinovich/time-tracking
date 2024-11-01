package com.time.tracking.model;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;
import java.time.LocalTime;

@Entity
@Table(name = "time_spent")
public class TimeSpent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    private LocalTime time;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private Timestamp createdAt;

    private Long projectId;
    private Long userId;

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public LocalTime getTime() {
        return time;
    }
    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public Long getProjectId() {
        return projectId;
    }

    public Long getUserId() {
        return userId;
    }
}
