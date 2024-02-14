package pl.atipera.githubbrowser.controllers;

import java.util.Collections;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pl.atipera.githubbrowser.models.Repository;

@RestController
@RequestMapping("/repositories")
public class RepositoriesController {

    @GetMapping(produces = "application/json")
    public Repository getTestRepository() {
        return new Repository("name", "owner", Collections.emptyList());
    }
}
