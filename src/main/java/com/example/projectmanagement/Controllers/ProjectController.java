package com.example.projectmanagement.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.projectmanagement.Model.Project;
import com.example.projectmanagement.services.ProjectService;

@Controller
@RequestMapping("/project")
public class ProjectController {

    private ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping("/list")
    public String getProjectList(Model model) {
        model.addAttribute("projects", projectService.getProjectList());
        model.addAttribute("employees", projectService.getAllEmployees());
        return "project-list"; // Thymeleaf template to display the project list
    }

    @GetMapping("/add")
    public String showAddProjectForm(Model model) {
        model.addAttribute("project", new Project()); // A blank project for the form binding
        return "add-project"; // Thymeleaf template for the add project form
    }

    @PostMapping("/add")
    public String addProject(@ModelAttribute("project") Project project) {
        projectService.saveProject(project); // Save the project using the service
        return "redirect:/project/list"; // Redirect back to the project list after saving
    }

    @GetMapping("/edit/{id}")
    public String editProject(@PathVariable("id") int id, Model model) {
        Project project = projectService.getProjectById(id);
        model.addAttribute("project", project);
        model.addAttribute("employees", projectService.getAllEmployees());
        model.addAttribute("assignedEmployees", projectService.getEmployeesByProject(id));
        return "edit-project";
    }

    @PostMapping("/assign-employee")
    public String assignEmployeeToProject(@RequestParam int projectId, @RequestParam int employeeId) {
        projectService.assignEmployeeToProject(projectId, employeeId);
        return "redirect:/project/edit/" + projectId;
    }

    @PostMapping("/employee/update-role")
    public String updateEmployeeRole(@RequestParam int employeeId, @RequestParam String newRole) {
        projectService.updateEmployeeRole(employeeId, newRole);
        return "redirect:/project/list"; // Redirect back to the project list or employee list
    }
  /*
  
    @PostMapping("/delete/{id}")
    public String deleteProject(@PathVariable("id") int id) {
        projectService.deleteProject(id);
        return "redirect:/project/list"; // Redirect back to the project list
    }

     */
}
