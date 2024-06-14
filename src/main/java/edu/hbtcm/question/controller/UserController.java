package edu.hbtcm.question.controller;

import edu.hbtcm.question.entity.User;
import edu.hbtcm.question.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;
    //find
    @GetMapping
    public List<User> findAll() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public User findById(@PathVariable Long id) {
        return userService.findById(id);
    }

    @GetMapping("{username}")
    public User findByUsername(@PathVariable String username) {
        return userService.findByUsername(username);
    }

    @GetMapping("{email}")
    public User findByEmail(@PathVariable String email) {
        return userService.findByEmail(email);
    }

    @GetMapping("{phone}")
    public User findByPhone(@PathVariable String phone) {
        return userService.findByPhone(phone);
    }
    //new
    @PostMapping
    public User save(@RequestBody User user) {
        return userService.save(user);
    }
    //delete
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        userService.deleteById(id);
    }
    //update
    @PutMapping
    public User update(@RequestBody User user) {
        return userService.update(user);
    }
}