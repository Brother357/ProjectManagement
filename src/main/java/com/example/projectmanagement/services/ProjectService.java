package com.example.projectmanagement.services;

import com.example.projectmanagement.Model.Employee;
import com.example.projectmanagement.Model.Project;
import com.example.projectmanagement.repositories.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {
    private ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public List<Project> getProjectList() {
        return projectRepository.getProjectList();
    }

    // New method to save a project
    public void saveProject(Project project) {
        projectRepository.saveProject(project); // Save project using the repository
    }

    public List<Employee> getAllEmployees() {
        return projectRepository.getAllEmployees();
    }

    public void assignEmployeeToProject(int projectId, int employeeId) {
        projectRepository.assignEmployeeToProject(projectId, employeeId);
    }

    public List<Employee> getEmployeesByProject(int projectId) {
        return projectRepository.getEmployeesByProjectId(projectId);
    }

    public Project getProjectById(int id) {
        return projectRepository.getProjectById(id);
    }

    public void updateEmployeeRole(int employeeId, String newRole) {
        projectRepository.updateEmployeeRole(employeeId, newRole);
    }
}
