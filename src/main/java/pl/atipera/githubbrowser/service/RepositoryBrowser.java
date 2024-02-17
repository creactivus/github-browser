package pl.atipera.githubbrowser.service;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import pl.atipera.githubbrowser.error.exception.UserNotFoundException;
import pl.atipera.githubbrowser.model.Repository;

@Service
public class RepositoryBrowser {
    private static final String GITHUB_URL = "https://api.github.com";
    private static final String USER_REPOS_URI = "/users/%s/repos";
    private static final String REPO_BRANCHES_URI = "/repos/%s/%s/branches";
    private final RestClient restClient = RestClient.create();

    public List<Repository> getUserRepositories(String user) {
        final List<Repository> repositories = restClient.get()
                .uri(String.format(GITHUB_URL + USER_REPOS_URI, user))
                .retrieve()
                .onStatus(status -> status.value() == 404, (request, response) -> {
                    throw new UserNotFoundException("User does not exist.");
                })
                .body(new ParameterizedTypeReference<>() {});
        return repositories.parallelStream()
                .filter(Predicate.not(Repository::isFork))
                .map(this::loadBranches)
                .collect(Collectors.toList());
    }

    private Repository loadBranches(Repository repository) {
        repository.setBranches(restClient.get()
                .uri(String.format(GITHUB_URL + REPO_BRANCHES_URI, repository.getOwner(), repository.getName()))
                .retrieve()
                .body(new ParameterizedTypeReference<>() {}));
        return repository;
    }
}
