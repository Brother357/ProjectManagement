package com.example.projectmanagement.Model;

import java.util.ArrayList;
import java.util.List;

public class Project {
    private int id;
    private String name;
    private String deadline;
    private String duration;

    public Project(int id, String name, String deadline, String duration) {
        this.id = id;
        this.name = name;
        this.deadline = deadline;
        this.duration = duration;
    }

    public Project() {

    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", deadline='" + deadline + '\'' +
                ", duration='" + duration + '\'' +
                '}';
    }

    // Getters and setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDeadline() { return deadline; }
    public void setDeadline(String deadline) { this.deadline = deadline; }

    public String getDuration() { return duration; }
    public void setDuration(String duration) { this.duration = duration; }


    private List<Employee> employees = new ArrayList<>();

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

}
