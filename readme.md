# GitHub API Automation Tests

This project contains TestNG-based automation tests for GitHub API operations using Rest Assured.

## Setup

### Prerequisites

- Java Development Kit (JDK) installed
- Maven installed
- IntelliJ IDEA (optional, for development)

### Dependencies

- TestNG
- Rest Assured
- Lombok (if used for POJOs)
- Jackson or Gson for JSON serialization/deserialization

### Configuration

1. Clone this repository:
   ```bash
   git clone https://github.com/your-username/github-api-automation.git
2. Open the project in IntelliJ IDEA or your preferred IDE.
3. Ensure JDK and Maven are configured in your IDE.
4. Update the auth_token, baseUrl, and other necessary parameters in the GitHubAPIAutomation class according to your GitHub account and setup.
5. Configure Lombok annotation processing in your IDE if you're using Lombok for POJOs.

### Apis Automated

1. Create Repository
   ```bash
   curl -X POST \
   -H "Accept: application/vnd.github+json" \
   -H "Authorization: Bearer <YOUR-TOKEN>" \
   -H "X-GitHub-Api-Version: 2022-11-28" \
   https://api.github.com/orgs/ORG/repos \
   -d '{"name":"Hello-World","description":"This is your first repository","homepage":"https://github.com","private":false,"has_issues":true,"has_projects":true,"has_wiki":true}'
1. Create Issue
   ```bash
   curl -X POST \
   -H "Accept: application/vnd.github+json" \
   -H "Authorization: Bearer <YOUR-TOKEN>" \
   -H "X-GitHub-Api-Version: 2022-11-28" \
   https://api.github.com/repos/OWNER/REPO/issues \
   -  d '{"title":"Found a bug","body":"I'\''m having a problem with this.","assignees":["octocat"],"milestone":1,"labels":["bug"]}'
1. Close Issue
   ```bash
   curl -X PATCH \
   -H "Accept: application/vnd.github+json" \
   -H "Authorization: Bearer <YOUR-TOKEN>" \
   -H "X-GitHub-Api-Version: 2022-11-28" \
   https://api.github.com/repos/OWNER/REPO/issues/ISSUE_NUMBER \
   -d '{"title":"Found a bug","body":"I'\''m having a problem with this.","assignees":["octocat"],"milestone":1,"state":"closed","labels":["bug"]}'

Replace <YOUR-TOKEN>, ORG, OWNER, REPO, and ISSUE_NUMBER with the actual values for your GitHub repository and authentication token.

## Running Tests
## IntelliJ IDEA
Open the project in IntelliJ IDEA.

Create a TestNG run configuration:

Go to Run -> Edit Configurations.
Click the + icon, select TestNG.
Specify the test class (GitHubAPIAutomation) in the Class field.
Apply and close the configuration window.
Run the TestNG configuration.

### Command Line (Maven)
Execute the following command in the project root directory:
```bash
mvn clean test -Dtest=GitHubAPIAutomation
