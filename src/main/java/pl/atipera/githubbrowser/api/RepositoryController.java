package pl.atipera.githubbrowser.api;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import pl.atipera.githubbrowser.model.Repository;
import pl.atipera.githubbrowser.service.RepositoryBrowser;

@RestController
@RequestMapping("api/repos")
@RequiredArgsConstructor
public class RepositoryController {
    private final RepositoryBrowser gitHubService;

    @GetMapping(value = "/{user}", produces = "application/json")
    public List<Repository> getUserRepositories(@PathVariable String user) {
        return gitHubService.getUserRepositories(user);
    }
}
