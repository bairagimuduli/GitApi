
package org.example.pojo;

import lombok.Data;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "url",
    "html_url",
    "labels_url",
    "id",
    "node_id",
    "number",
    "state",
    "title",
    "description",
    "creator",
    "open_issues",
    "closed_issues",
    "created_at",
    "updated_at",
    "closed_at",
    "due_on"
})
@Data
public class Milestone {

    @JsonProperty("url")
    public String url;
    @JsonProperty("html_url")
    public String htmlUrl;
    @JsonProperty("labels_url")
    public String labelsUrl;
    @JsonProperty("id")
    public Integer id;
    @JsonProperty("node_id")
    public String nodeId;
    @JsonProperty("number")
    public Integer number;
    @JsonProperty("state")
    public String state;
    @JsonProperty("title")
    public String title;
    @JsonProperty("description")
    public String description;
    @JsonProperty("creator")
    public Creator creator;
    @JsonProperty("open_issues")
    public Integer openIssues;
    @JsonProperty("closed_issues")
    public Integer closedIssues;
    @JsonProperty("created_at")
    public String createdAt;
    @JsonProperty("updated_at")
    public String updatedAt;
    @JsonProperty("closed_at")
    public String closedAt;
    @JsonProperty("due_on")
    public String dueOn;

}
