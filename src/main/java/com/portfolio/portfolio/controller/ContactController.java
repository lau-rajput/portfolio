package com.portfolio.portfolio.controller;

import com.portfolio.portfolio.dto.ContactForm;
import com.portfolio.portfolio.model.ContactMessage;
import com.portfolio.portfolio.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ContactController {

    @Autowired
    private ContactRepository repo;

    @PostMapping("/contact")
    public String submitForm(@RequestBody ContactForm form) {

        System.out.println("========= NEW MESSAGE =========");
        System.out.println("Name: " + form.getName());
        System.out.println("Email: " + form.getEmail());
        System.out.println("Message: " + form.getMessage());
        System.out.println("================================");

        // 👉 Save to MySQL
        ContactMessage msg = new ContactMessage(
                form.getName(),
                form.getEmail(),
                form.getMessage()
        );

        repo.save(msg);

        return "Message saved to MySQL!";
    }
}
