package com.example.multimodel.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MultiChatController {

    private final ChatClient openaAiChatClient;

    private final ChatClient ollamaChatClient;

    public MultiChatController(@Qualifier("openAiChatClient") ChatClient openaAiChatClient,
                               @Qualifier("ollamaChatClient") ChatClient ollamaChatClient) {
        this.openaAiChatClient = openaAiChatClient;
        this.ollamaChatClient = ollamaChatClient;
    }

    @GetMapping("/openai/chat")
    public String openAiChat(@RequestParam String message) {
        return openaAiChatClient.prompt(message).call().content();
    }

    @GetMapping("/ollama/chat")
    public String ollamaChat(@RequestParam String message) {
        return ollamaChatClient.prompt(message).call().content();
    }
}
