package org.abosk.openaiclient.service;

import org.abosk.openaiclient.model.OpenAiRequest;
import org.abosk.openaiclient.model.OpenAiResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

@Service
public class OpenAiService {
    private static final Logger log = LoggerFactory.getLogger(OpenAiService.class);

    private final WebClient webClient;

    @Value("${openai.api.model}") String model;

    public OpenAiService(
            @Value("${openai.api.url}") String apiUrl,
            @Value("${openai.api.key}") String apiKey
    ) {
        log.info("🔧 Configuring OpenAI Service with URL: [{}]", apiUrl);
        log.info("🔧 Using API key: [{}]", apiKey);
        this.webClient = WebClient.builder()
                .baseUrl(apiUrl)
                .defaultHeader("Authorization", "Bearer " + apiKey)
                .build();
    }

    public String chat(String prompt) {
        log.info("🟡 Prompt original: [{}]", prompt);

        // Normaliza espacios (espacios múltiples, tabs, saltos de línea → espacio simple)
        String normalizedPrompt = prompt.trim().replaceAll("\\s+", " ");
        log.info("🟢 Prompt normalized: [{}]", normalizedPrompt);

        OpenAiRequest request = new OpenAiRequest(
                model,
                List.of(Map.of("role", "user", "content", normalizedPrompt))
        );

        OpenAiResponse response = webClient.post()
                .bodyValue(request)
                .retrieve()
                .bodyToMono(OpenAiResponse.class)
                .block();

        String reply = response.choices().get(0).message().content();
        log.info("🔵 Respuesta de OpenAI: [{}]", reply);

        return reply;
    }
}
