package pl.atipera.githubbrowser.api;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class RepositoryControllerIT {
    private static final String ACCEPT = "Accept";
    private static final String APPLICATION_JSON = "application/json";
    @Autowired
    private WebTestClient webTestClient;

    @Test
    public void givenExistentUserWhenGetTheirRepositoriesThenFound() {
        this.webTestClient
        .get()
        .uri("/api/repos/hornbeck")
        .header(ACCEPT, APPLICATION_JSON)
        .exchange()
        .expectStatus()
        .isOk()
        .expectHeader()
        .contentType(APPLICATION_JSON)
        .expectBody()
        .jsonPath("$[0].name")
        .isNotEmpty()
        .jsonPath("$[0].owner")
        .isNotEmpty()
        .jsonPath("$[0].branches[0].name")
        .isNotEmpty()
        .jsonPath("$[0].branches[0].lastCommit")
        .isNotEmpty();
    }

    @Test
    public void givenNonexistentUserWhenGetTheirRepositoriesThenNotFound() {
        this.webTestClient
        .get()
        .uri("/api/repos/" + System.currentTimeMillis())
        .header(ACCEPT, APPLICATION_JSON)
        .exchange()
        .expectStatus()
        .isNotFound()
        .expectHeader()
        .contentType(APPLICATION_JSON)
        .expectBody()
        .jsonPath("message")
        .isEqualTo("User does not exist.");
    }
}
