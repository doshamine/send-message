package com.example.sendmessage;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClient;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;

@Controller
@RequestMapping("/send-message")
public class SendMessageController {
    private MessageRepository messageRepository;

    public SendMessageController(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @ModelAttribute("message")
    public Message getMessage() throws UnknownHostException {
        Message message = new Message();
        message.setAuthor(InetAddress.getLocalHost().getHostAddress());
        return message;
    }

    @GetMapping
    public String show_form(Model model) {
        String receive_addr = "";
        model.addAttribute("receive_addr", receive_addr);
        return "message-form";
    }

    @PostMapping
    public String send_form(
            @ModelAttribute("message") Message message,
            @ModelAttribute("receive_addr") String receive_addr
    ) {
        messageRepository.save(message);
        RestClient restClient = RestClient.create();

        System.out.println(receive_addr);
        restClient.post()
                .uri(receive_addr+":8080/receive-message")
                .contentType(MediaType.APPLICATION_JSON)
                .body(message)
                .retrieve()
                .toBodilessEntity();

        return "redirect:/send-message";
    }
}
