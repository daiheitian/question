package edu.hbtcm.question.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.util.Base64;
import java.util.Random;

@RestController
public class CaptchaController {

    private String captchaCode;

    @GetMapping("/captcha")
    public String getCaptcha() throws Exception {
        int width = 150;
        int height = 50;

        char[] chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890".toCharArray();
        StringBuilder sb = new StringBuilder();
        Random random = new Random();

        BufferedImage captcha = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = captcha.createGraphics();

        g2d.setColor(new Color(255, 255, 255));
        g2d.fillRect(0, 0, width, height);

        g2d.setColor(new Color(0, 0, 0));
        g2d.setFont(new Font("Arial", Font.BOLD, 40));

        for (int i = 0; i < 5; i++) {
            char c = chars[random.nextInt(chars.length)];
            sb.append(c);
            int x = i * 30;
            g2d.drawString(String.valueOf(c), x, 40);
        }

        g2d.dispose();

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(captcha, "png", baos);
        byte[] bytes = baos.toByteArray();

        captchaCode = sb.toString();

        return Base64.getEncoder().encodeToString(bytes);
    }

    public String getCaptchaCode() {
        return captchaCode;
    }
}