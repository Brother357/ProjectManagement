package com.example.projectmanagement.View;

import com.example.projectmanagement.Model.Project;

public class ProjectView {
    public void displayProjectDetails(Project project) {
        System.out.println("Project ID: " + project.getId());
        System.out.println("Project Name: " + project.getName());
        System.out.println("Deadline: " + project.getDeadline());
        System.out.println("Duration: " + project.getDuration());
    }
}
