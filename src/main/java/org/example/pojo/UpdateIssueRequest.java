
package org.example.pojo;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "title",
    "body",
    "assignees",
    "milestone",
    "state",
    "labels"
})
@Data
public class UpdateIssueRequest {

    @JsonProperty("title")
    public String title;
    @JsonProperty("body")
    public String body;
    @JsonProperty("assignees")
    public List<String> assignees;
    @JsonProperty("milestone")
    public Integer milestone;
    @JsonProperty("state")
    public String state;
    @JsonProperty("labels")
    public List<String> labels;

}
