package edu.hbtcm.question.controller;

import edu.hbtcm.question.entity.User;
import edu.hbtcm.question.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private CaptchaController captchaController;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> request) {
        String username = request.get("username");
        String password = request.get("password");
        String captcha = request.get("captcha");

        User existingUser = userService.findByUsername(username);

        if (existingUser != null && existingUser.getPassword().equals(password) && captchaController.getCaptchaCode().equals(captcha)) {
            // 登录成功
            return ResponseEntity.ok().body("Login successful");
        } else {
            // 登录失败
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username, password or captcha");
        }
    }
}