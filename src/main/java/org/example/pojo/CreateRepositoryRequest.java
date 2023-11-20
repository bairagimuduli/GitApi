package org.example.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "name",
        "description",
        "homepage",
        "private",
        "has_issues",
        "has_projects",
        "has_wiki"
})
@Data
public class CreateRepositoryRequest {

    @JsonProperty("name")
    public String name;
    @JsonProperty("description")
    public String description;
    @JsonProperty("homepage")
    public String homepage;
    @JsonProperty("private")
    public Boolean _private;
    @JsonProperty("has_issues")
    public Boolean hasIssues;
    @JsonProperty("has_projects")
    public Boolean hasProjects;
    @JsonProperty("has_wiki")
    public Boolean hasWiki;

}