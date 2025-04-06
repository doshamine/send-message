package com.example.sendmessage;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClient;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Map;

@Controller
public class ReceiveMessageController {
    private MessageRepository messageRepository;

    public ReceiveMessageController(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @GetMapping("/show-messages")
    public String show_messages(Model model) {
        model.addAttribute("messages", messageRepository.findAll());
        return "show-messages";
    }

    @PostMapping("/receive-message")
    public String receive_message(@RequestBody Message message) {
        messageRepository.save(message);
        return "redirect:/show-messages";
    }
}
