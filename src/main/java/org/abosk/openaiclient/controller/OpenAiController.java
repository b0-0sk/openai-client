package org.abosk.openaiclient.controller;

import org.abosk.openaiclient.service.OpenAiService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/openai")
public class OpenAiController {

    private final OpenAiService service;

    public OpenAiController(OpenAiService service) {
        this.service = service;
    }

    @PostMapping("/chat")
    public String chat(@RequestBody Map<String, String> body) {
        String prompt = body.getOrDefault("prompt", "").trim();
        return service.chat(prompt);
    }
}
