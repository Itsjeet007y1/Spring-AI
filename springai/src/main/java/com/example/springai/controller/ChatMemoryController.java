package com.example.springai.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ChatMemoryController {

    private final ChatClient chatClient;

    public ChatMemoryController(@Qualifier("chatMemoryChatClient") ChatClient chatClient) {
        this.chatClient = chatClient;
    }

     // This endpoint is just for demonstration. In a real application, you would have more meaningful interactions.
     @GetMapping("/chat-memory")
     public ResponseEntity<String> memory(@RequestParam String message) {
         return ResponseEntity.ok(chatClient
                 .prompt()
                 .user(message)
                 .call().content());
     }
}
