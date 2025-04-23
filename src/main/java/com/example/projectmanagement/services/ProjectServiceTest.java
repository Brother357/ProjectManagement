/*

package com.example.projectmanagement.services;

import com.example.projectmanagement.Model.Employee;
import com.example.projectmanagement.Model.Project;
import com.example.projectmanagement.repositories.ProjectRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProjectServiceTest {

    @Mock
    private ProjectRepository projectRepository;

    @InjectMocks
    private ProjectService projectService;

    private Project project;
    private Employee employee;

    @BeforeEach
    void setUp() {
        project = new Project(1, "Test Project", "2024-12-31", "6 months");
        employee = new Employee(1, "John Doe", "Developer");
    }

    @Test
    void testGetProjectList() {
        when(projectRepository.getProjectList()).thenReturn(Arrays.asList(project));

        List<Project> projects = projectService.getProjectList();

        assertNotNull(projects);
        assertEquals(1, projects.size());
        assertEquals("Test Project", projects.get(0).getName());

        verify(projectRepository, times(1)).getProjectList();
    }

}

 */