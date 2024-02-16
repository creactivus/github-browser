package pl.atipera.githubbrowser.model;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

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
public class Repository {
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
