package org.example.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.example.pojo.*;

import java.util.Arrays;
import java.util.List;

public class GitHubRepo {
    private String baseUrl = "https://api.github.com";
    ObjectMapper objectMapper;

    public void setUp(String authToken) {
        RestAssured.baseURI = baseUrl;
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        RestAssured.requestSpecification = RestAssured.given()
                .header("Authorization", "Bearer " + authToken)
                .header("Content-Type", "application/json")
                .header("Accept", "application/vnd.github.v3+json");
        objectMapper = new ObjectMapper();
    }
    public CreateRepositoryResponse createRepository(String orgName, String repoName, String description, int statusCodeToValidate) throws JsonProcessingException {
        CreateRepositoryRequest repositoryRequest = new CreateRepositoryRequest();
        repositoryRequest.setName(repoName);
        repositoryRequest.setDescription(description);
        repositoryRequest.setHomepage("https://github.com");
        repositoryRequest.set_private(false);
        repositoryRequest.setHasIssues(true);
        repositoryRequest.setHasProjects(true);
        repositoryRequest.setHasWiki(true);

        String finalEndpoint = String.format("/orgs/%s/repos", orgName);

        Response response = RestAssured.given()
                .body(repositoryRequest)
                .post(finalEndpoint);

        response.then().statusCode(statusCodeToValidate);
        return objectMapper.readValue(response.prettyPrint(), CreateRepositoryResponse.class);
    }

    public CreateIssueResponse createIssues(String repoName, String owner, String title, String issueDetails, int statusCodeToValidate) throws JsonProcessingException {
        CreateIssueRequest issueRequest = new CreateIssueRequest();
        issueRequest.setTitle(title);
        issueRequest.setBody(issueDetails);
        issueRequest.setAssignees(List.of("octocat"));
        issueRequest.setMilestone(1);
        issueRequest.setLabels(List.of("bug"));

        String finalEndpoint = String.format("/repos/%s/%s/issues", owner, repoName);


        Response response = RestAssured.given()
                .body(issueRequest)
                .post(finalEndpoint);

        response.then().statusCode(statusCodeToValidate);
        return objectMapper.readValue(response.prettyPrint(), CreateIssueResponse.class);
    }

    public UpdateIssueResponse closeIssues(String repoName, String owner, int issueNumber, int statusCodeToValidate) throws JsonProcessingException {
        UpdateIssueRequest updateIssueRequest = new UpdateIssueRequest();
        updateIssueRequest.setAssignees(Arrays.asList("octocat"));
        updateIssueRequest.setMilestone(1);
        updateIssueRequest.setState("closed");
        updateIssueRequest.setLabels(Arrays.asList("bug"));

        String finalEndpoint = String.format("/repos/%s/%s/issues/%d", owner, repoName, issueNumber);

        Response response = RestAssured.given()
                .body(updateIssueRequest)
                .patch(finalEndpoint);

        response.then().statusCode(statusCodeToValidate);
        return objectMapper.readValue(response.prettyPrint(),UpdateIssueResponse.class);
    }

}
