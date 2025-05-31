package org.abosk.openaiclient.integration;

import org.abosk.openaiclient.service.OpenAiService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class OpenAiApiConnectivityTest {

    @Autowired
    private OpenAiService openAiService;

    @Test
    void shouldConnectToOpenAiApiAndReceiveResponse() {
        // given
        String prompt = "Say hello in one sentence.";

        // when
        String response = openAiService.chat(prompt);

        // then
        assertThat(response).isNotNull();
        assertThat(response).containsIgnoringCase("hello");
    }
}
