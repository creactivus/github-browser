package pl.atipera.githubbrowser.api;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import pl.atipera.githubbrowser.model.Repository;
import pl.atipera.githubbrowser.service.GitHubService;

@RestController
@RequestMapping("api")
@RequiredArgsConstructor
public class GitHubBrowser {
    private final GitHubService gitHubService;

    @GetMapping(value = "/repos/{user}", produces = "application/json")
    public List<Repository> sayHello(@PathVariable String user) {
        return gitHubService.getUserRepositories(user);
    }
}