package com.example.projectmanagement.View;

import com.example.projectmanagement.Model.TeamGroup;
import com.example.projectmanagement.Model.Employee;

public class TeamGroupView {
    public void displayTeamGroupDetails(TeamGroup group) {
        System.out.println("Team Group ID: " + group.getId());
        System.out.println("Team Group Name: " + group.getName());
        System.out.println("Projects in this group:");
        group.getProjects().forEach(project -> System.out.println("- " + project.getName()));

        System.out.println("Employees in this group:");
        for (Employee employee : group.getEmployees()) {
            System.out.println("- " + employee.getName() + " (" + employee.getRole() + ")");
        }
    }
}
