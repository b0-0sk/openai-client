package org.abosk.openaiclient.model;

import java.util.List;
import java.util.Map;

public record OpenAiRequest(
        String model,
        List<Map<String, String>> messages
) {}