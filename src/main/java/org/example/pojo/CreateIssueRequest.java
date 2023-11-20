package org.example.pojo;

import lombok.Data;

import java.util.List;

@Data
public class CreateIssueRequest {
    private String title;
    private String body;
    private List<String> assignees;
    private int milestone;
    private List<String> labels;
}
