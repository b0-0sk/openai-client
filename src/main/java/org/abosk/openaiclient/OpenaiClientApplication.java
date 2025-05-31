package org.abosk.openaiclient;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableEncryptableProperties
public class OpenaiClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(OpenaiClientApplication.class, args);
    }
}
