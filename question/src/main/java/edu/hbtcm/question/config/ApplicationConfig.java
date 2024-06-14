package edu.hbtcm.question.config;

import edu.hbtcm.question.entity.User;
import edu.hbtcm.question.repository.UserRepository;
import edu.hbtcm.question.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {
    @Autowired
    private UserRepository userRepository;

    @Bean
    public UserService userService() {
        return new UserService(userRepository);
    }
}