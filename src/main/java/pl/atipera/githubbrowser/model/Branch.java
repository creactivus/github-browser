package pl.atipera.githubbrowser.model;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Branch extends GitHubEntity {
    @JsonProperty
    private String name;
    private String lastCommit;

    @JsonProperty("commit")
    private void getLastCommitSha(Map<String, String> commit) {
        lastCommit = commit.get("sha");
    }
}
