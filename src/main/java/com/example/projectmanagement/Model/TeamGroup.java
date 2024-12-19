package com.example.projectmanagement.Model;

import java.util.ArrayList;
import java.util.List;

public class TeamGroup {
    private int id;
    private String name;
    private List<Project> projects;
    private List<Employee> employees; // New field for employees

    public TeamGroup(int id, String name) {
        this.id = id;
        this.name = name;
        this.projects = new ArrayList<>();
        this.employees = new ArrayList<>(); // Initialize employees list
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public List<Project> getProjects() { return projects; }
    public void addProject(Project project) { this.projects.add(project); }

    public List<Employee> getEmployees() { return employees; }
    public void addEmployee(Employee employee) { this.employees.add(employee); }
    public void removeEmployee(Employee employee) { this.employees.remove(employee); }
}
