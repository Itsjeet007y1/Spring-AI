package com.example.springai.config;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.SimpleLoggerAdvisor;
import org.springframework.ai.chat.prompt.ChatOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ChatClientConfig {

    @Bean
    public ChatClient chatClient(ChatClient.Builder chatClientBuilder) {
        ChatOptions chatOptions = ChatOptions.builder().model("gpt-3.5-turbo")
                .maxTokens(10)
                .temperature(0.7)
                .build();

        return chatClientBuilder
                .defaultAdvisors(new SimpleLoggerAdvisor())
//                .defaultOptions(chatOptions)
                .defaultSystem("You are an internal HR assistant. Your role is to help" +
                        " employees with questions related to HR policies, such as " +
                        "leave policies, working hours, benefits, and other HR-related inquiries. " +
                        "If a user asks for help with anything outside ot these topics," +
                        " politely inform them that you can only assist with HR-related questions.")
                .defaultUser("How can you help me?")
                .build();
    }
}
