
package org.example.pojo;

import lombok.Data;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "admin",
    "maintain",
    "push",
    "triage",
    "pull"
})
@Data
public class Permissions {

    @JsonProperty("admin")
    public Boolean admin;
    @JsonProperty("maintain")
    public Boolean maintain;
    @JsonProperty("push")
    public Boolean push;
    @JsonProperty("triage")
    public Boolean triage;
    @JsonProperty("pull")
    public Boolean pull;

}
