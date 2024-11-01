package com.time.tracking.controller;

import com.time.tracking.model.User;
import com.time.tracking.service.UserService;
import com.time.tracking.util.UtilController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@RequestHeader(value = "Authorization") String auth, @PathVariable Long id) {
        if(UtilController.hasRoleAdmin(auth)) {
            return new ResponseEntity<>( userService.get(id), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(@RequestHeader(value = "Authorization") String auth) {
        if(UtilController.hasRoleAdmin(auth)) {
            return new ResponseEntity<>(userService.getAll(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestHeader(value = "Authorization") String auth, @RequestBody User user) {
        if(UtilController.hasRoleAdmin(auth)) {
            return new ResponseEntity<>(userService.create(user), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@RequestHeader(value = "Authorization") String auth, @RequestBody User user) {
        if(UtilController.hasRoleAdmin(auth)) {
            return new ResponseEntity<>(userService.update(user), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@RequestHeader(value = "Authorization") String auth, @PathVariable Long id) {
        if(UtilController.hasRoleAdmin(auth)) {
            userService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }
}
