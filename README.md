# 🤖 OpenAI Client · Java + Spring Boot

This project is a secure, production-ready integration with the [OpenAI API](https://platform.openai.com/docs/api-reference), built using **Java 21** and **Spring Boot**. It provides a clean and extensible service for interacting with ChatGPT models via HTTP.

---

## 🚀 Features

* 🔐 **Encrypted API key support** via [Jasypt](https://github.com/ulisesbocchio/jasypt-spring-boot)
* 📡 **Connects to OpenAI Chat Completion endpoint**
* 🧪 **Integration test** to verify external API connectivity
* 🧰 Configuration via `application.properties`
* ✅ CI-ready with [GitHub Actions](.github/workflows/ci.yml)

---

## ⚙️ Requirements

* Java 21
* Maven 3.8+
* OpenAI API Key (use [environment secret](https://docs.github.com/en/actions/security-guides/encrypted-secrets) or Jasypt)

---

## 🔧 Configuration

All sensitive configuration is encrypted using Jasypt.

### 🔐 Required properties:

```properties
openai.api.url=https://api.openai.com/v1/chat/completions
openai.api.model=gpt-3.5-turbo
openai.api.key=ENC(ENCRYPTED_KEY_HERE)
jasypt.encryptor.algorithm=PBEWithMD5AndTripleDES
```

The Jasypt password must be provided via:

* VM Option:

  ```
  -Djasypt.encryptor.password=your-secret
  ```
* Or GitHub Actions secret: `JASYPT_PASSWORD`

---

## ▶️ Usage

Inject the service:

```java
@Autowired
private OpenAiService openAiService;

String reply = openAiService.chat("Hello, how are you?");
System.out.println(reply);
```

---

## 🧪 Integration Test

A test class (`OpenAiApiConnectivityTest`) ensures that the application can reach OpenAI and receive a valid response.

Run it with:

```bash
mvn test -Djasypt.encryptor.password=your-secret
```

---

## ⚙️ GitHub Actions CI

This project includes a GitHub Actions workflow that:

* Builds and tests your app on push/pull requests
* Uses secrets to pass the Jasypt password securely

Secrets required:

| Name              | Description                      |
| ----------------- | -------------------------------- |
| `JASYPT_PASSWORD` | Password to decrypt your API key |

---

## 📁 Project structure

```
src
├── main
│   └── java/org/abosk/openaiclient
│       ├── config
│       ├── service
│       └── controller
├── test
│   └── java/org/abosk/openaiclient/integration
└── resources
    └── application.properties
```

---

## 📄 License

This project is open-source and available under the [MIT License](LICENSE).

---

## 👨‍💻 Author

**Arnau Bosch**
🔗 [LinkedIn](https://www.linkedin.com/in/arnau-bosch-g%C3%B3mez-092709236/)
🐙 [GitHub](https://github.com/b0-0sk)
