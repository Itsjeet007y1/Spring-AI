package com.example.springai.controller;

import com.example.springai.model.CountryCities;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.SimpleLoggerAdvisor;
import org.springframework.ai.converter.ListOutputConverter;
import org.springframework.ai.converter.MapOutputConverter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class StructuredOutputController {

    private final ChatClient chatClient;

    public StructuredOutputController(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder.build();
    }

    @GetMapping("/chat-bean")
    public ResponseEntity<CountryCities> chat(@RequestParam String message) {
        CountryCities countryCities = chatClient
                .prompt()
                .advisors(new SimpleLoggerAdvisor())
                .user(message)
                .call().entity(CountryCities.class);
        return ResponseEntity.ok(countryCities);
    }

    @GetMapping("/chat-list")
    public ResponseEntity<List<String>> chatList(@RequestParam String message) {
        List<String> list = chatClient
                .prompt()
                .advisors(new SimpleLoggerAdvisor())
                .user(message)
                .call().entity(new ListOutputConverter());
        return ResponseEntity.ok(list);
    }

    @GetMapping("/chat-map")
    public ResponseEntity<Map<String, Object>> chatMap(@RequestParam String message) {
        Map<String, Object> list = chatClient
                .prompt()
                .advisors(new SimpleLoggerAdvisor())
                .user(message)
                .call().entity(new MapOutputConverter());
        return ResponseEntity.ok(list);
    }
}
