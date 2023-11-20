import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.Getter;
import lombok.Setter;
import org.example.pojo.CreateIssueResponse;
import org.example.pojo.CreateRepositoryResponse;
import org.example.pojo.UpdateIssueResponse;
import org.example.services.GitHubRepo;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GitHubAPIAutomation {

    GitHubRepo gitHubRepo;
    private final String orgName = "bairagitest";
    private final String owner = "bairagimuduli";
    private final String repoName = "hey3"; // change this as the same name will be conflict
    @Getter
    @Setter
    int issueNumber;

    @BeforeClass
    public void setUp() {
        gitHubRepo = new GitHubRepo();
        String authToken = "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"; // this needs to be change as per user
        gitHubRepo.setUp(authToken);
    }

    @Test(description = "Create a new repository", priority = 1)
    public void createRepository() throws JsonProcessingException {
        String description = "this is a automated way of creating the repo";
        CreateRepositoryResponse repository = gitHubRepo.createRepository(orgName, repoName, description, 201);
        Assert.assertEquals(repository.getFullName(), orgName+"/"+repoName,"organisation and repo name is not matched");
    }

    @Test(description = "Create 1st new issues", priority = 2)
    public void createIssues1() throws JsonProcessingException {
        String issueTitle = "This is 1st issue";
        String issueDetails = "This is the 1st issue details";
        CreateIssueResponse issues = gitHubRepo.createIssues(orgName, owner, issueTitle, issueDetails, 201);
        Assert.assertEquals(issues.getTitle(), issueTitle, "title mismatch");
        Assert.assertEquals(issues.getBody(), issueDetails, "title mismatch");
    }

    @Test(description = "Create 2nd new issues", priority = 3)
    public void createIssues2() throws JsonProcessingException {
        String issueTitle = "This is 2nd issue";
        String issueDetails = "This is the 2nd issue details";
        CreateIssueResponse issues = gitHubRepo.createIssues(orgName, owner, issueTitle, issueDetails, 201);
        Assert.assertEquals(issues.getTitle(), issueTitle, "title mismatch");
        Assert.assertEquals(issues.getBody(), issueDetails, "title mismatch");
        setIssueNumber(issues.getNumber());
    }

    @Test(description = "Close issues", priority = 4 )
    public void closeIssues() throws JsonProcessingException {
        UpdateIssueResponse updateIssueResponse = gitHubRepo.closeIssues(repoName, owner, getIssueNumber(), 200);
        Assert.assertEquals(updateIssueResponse.getState(), "closed");
    }
}