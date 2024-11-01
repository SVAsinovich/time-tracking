package com.time.tracking.controller;

import com.time.tracking.model.TimeSpent;
import com.time.tracking.service.TimeSpentService;
import com.time.tracking.util.UtilController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/time-spent")
public class TimeSpentController {

    private final TimeSpentService timeSpentService;

    @Autowired
    public TimeSpentController(TimeSpentService timeSpentService) {
        this.timeSpentService = timeSpentService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<TimeSpent> getTimeSpentById(@RequestHeader(value = "Authorization") String auth, @PathVariable Long id) {
        if(UtilController.hasRoleUser(auth)) {
            return new ResponseEntity<>(timeSpentService.get(id), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }

    @GetMapping
    public ResponseEntity<List<TimeSpent>> getAllTimeSpends(@RequestHeader(value = "Authorization") String auth) {
        if(UtilController.hasRoleUser(auth)) {
            return new ResponseEntity<>(timeSpentService.getAll(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }

    @PostMapping
    public ResponseEntity<TimeSpent> createTimeSpent(@RequestHeader(value = "Authorization") String auth, @RequestBody TimeSpent timeSpent) {
        if(UtilController.hasRoleUser(auth)) {
            return new ResponseEntity<>(timeSpentService.create(timeSpent), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TimeSpent> updateTimeSpent(@RequestHeader(value = "Authorization") String auth, @RequestBody TimeSpent timeSpent) {
        if(UtilController.hasRoleUser(auth)) {
            return new ResponseEntity<>(timeSpentService.update(timeSpent), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTimeSpent(@RequestHeader(value = "Authorization") String auth, @PathVariable Long id) {
        if(UtilController.hasRoleUser(auth)) {
            timeSpentService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }

    @GetMapping("/projectId/{projectId}")
    public ResponseEntity<List<TimeSpent>> getTimeSpentByProjectId(@RequestHeader(value = "Authorization") String auth, @PathVariable Long projectId) {
        if(UtilController.hasRoleUser(auth)) {
            return new ResponseEntity<>(timeSpentService.getAllByProjectId(projectId), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }

    @GetMapping("/userId/{userId}")
    public ResponseEntity<List<TimeSpent>> getTimeSpentByUserId(@RequestHeader(value = "Authorization") String auth, @PathVariable Long userId) {
        if(UtilController.hasRoleUser(auth)) {
            return new ResponseEntity<>(timeSpentService.getAllByUserId(userId), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }

    @GetMapping("/userId/{userId}/projectId/{projectId}")
    public ResponseEntity<List<TimeSpent>> getTimeSpentByUseIdAndProjectId(@RequestHeader(value = "Authorization") String auth, @PathVariable Long userId, @PathVariable Long projectId) {
        if(UtilController.hasRoleUser(auth)) {
            return new ResponseEntity<>(timeSpentService.getAllByUserIdAndProjectId(userId, projectId), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }
}
