package pl.atipera.githubbrowser.model;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class Branch {
    @JsonProperty
    private String name;
    private String lastCommit;

    @JsonProperty("commit")
    private void getLastCommitSha(Map<String, String> commit) {
        lastCommit = commit.get("sha");
    }
}
