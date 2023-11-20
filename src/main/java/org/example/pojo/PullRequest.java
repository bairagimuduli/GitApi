
package org.example.pojo;

import lombok.Data;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "url",
    "html_url",
    "diff_url",
    "patch_url"
})
@Data
public class PullRequest {

    @JsonProperty("url")
    public String url;
    @JsonProperty("html_url")
    public String htmlUrl;
    @JsonProperty("diff_url")
    public String diffUrl;
    @JsonProperty("patch_url")
    public String patchUrl;

}
