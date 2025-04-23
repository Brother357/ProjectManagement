package com.example.projectmanagement.repositories;

import com.example.projectmanagement.Model.Employee;
import com.example.projectmanagement.Model.Project;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProjectRepository {
    private JdbcTemplate jdbcTemplate;

    public ProjectRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Project> getProjectList() {
        String sql = "SELECT * FROM projects";
        RowMapper<Project> rowMapper = new BeanPropertyRowMapper<>(Project.class);
        return jdbcTemplate.query(sql, rowMapper);
    }

    // New method to save a project
    public void saveProject(Project project) {
        String sql = "INSERT INTO projects (name, deadline, duration) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, project.getName(), project.getDeadline(), project.getDuration());
    }

    public List<Employee> getAllEmployees() {
        String sql = "SELECT * FROM employees";
        RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<>(Employee.class);
        return jdbcTemplate.query(sql, rowMapper);
    }

    public void assignEmployeeToProject(int projectId, int employeeId) {
        String sql = "INSERT INTO project_employees (project_id, employee_id) VALUES (?, ?)";
        jdbcTemplate.update(sql, projectId, employeeId);
    }

    public List<Employee> getEmployeesByProjectId(int projectId) {
        String sql = "SELECT e.* FROM employees e " +
                "INNER JOIN project_employees pe ON e.id = pe.employee_id " +
                "WHERE pe.project_id = ?";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Employee.class), projectId);
    }

    public Project getProjectById(int id) {
        String sql = "SELECT * FROM projects WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Project.class), id);
    }

    public void updateEmployeeRole(int employeeId, String newRole) {
        String sql = "UPDATE employees SET role = ? WHERE id = ?";
        jdbcTemplate.update(sql, newRole, employeeId);
    }

}
