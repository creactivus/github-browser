package pl.atipera.githubbrowser.model;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Repository extends GitHubEntity {
    @JsonProperty
    private String name;
    private String owner;
    @JsonProperty(access = Access.WRITE_ONLY)
    private boolean fork;
    private List<Branch> branches;

    @JsonProperty("owner")
    private void getOwnerLogin(Map<String, String> owner) {
        this.owner = owner.get("login");
    }
}
