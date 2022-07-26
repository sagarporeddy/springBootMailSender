package com.mailSender.controller;
import java.util.Properties;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MailController {

        @GetMapping(value = "/sendMail")
        public void sendMail() {

        	JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        	mailSender.setHost("smtp.gmail.com");
        	mailSender.setPort(587);
        	mailSender.setUsername("abc@gmail.com");
        	mailSender.setPassword("8096102");
        	 
        	Properties properties = new Properties();
        	properties.setProperty("mail.smtp.auth", "true");
        	properties.setProperty("mail.smtp.starttls.enable", "true");
        	 
        	mailSender.setJavaMailProperties(properties);
        	
        	String from = "abc@gmail.com";
        	String to = "abcd@gmail.com";
        	 
        	SimpleMailMessage message = new SimpleMailMessage();
        	 
        	message.setFrom(from);
        	message.setTo(to);
        	message.setSubject("This is a plain text email");
        	message.setText("Hello guys! This is a plain text email.");
        	 
        	mailSender.send(message);

        }
}