package edu.hbtcm.question.service;

import edu.hbtcm.question.entity.User;
import edu.hbtcm.question.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username).orElse(null);
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email).orElse(null);
    }

    public User findByPhone(String phone) {
        return userRepository.findByPhone(phone).orElse(null);
    }
    //update
    public User update(User user) {
        return userRepository.save(user);
    }
}
// Compare this snippet from src/main/java/edu/hbtcm/question/repository/UserRepository.java:
// package edu.hbtcm.question.repository;