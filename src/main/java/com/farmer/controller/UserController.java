package com.farmer.controller;

import com.farmer.model.User;
import com.farmer.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    Logger logger = LoggerFactory.getLogger(UserController.class);

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("get/{id}")
    public ResponseEntity<User> getUser(@PathVariable("id") long id) {
        logger.info(String.format("method getUser start with id: %s", id));
        User user = userService.getUser(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<User>> getAllUser() {
        logger.info("start method getAllUser()");
        List<User> users = userService.getAllUser();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        logger.info("start method saveUser()");
        logger.info(user.toString());
        User savedItem = userService.saveUser(user);
        return new ResponseEntity<>(savedItem, HttpStatus.CREATED);
    }
}
