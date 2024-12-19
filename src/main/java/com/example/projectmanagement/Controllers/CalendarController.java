package com.example.projectmanagement.Controllers;

import com.example.projectmanagement.Model.Calendar;
import com.example.projectmanagement.Model.Project;
import com.example.projectmanagement.View.CalendarView;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/calendar")
public class CalendarController {
    private Calendar model;

    public CalendarController() {
        this.model = new Calendar();
    }

    @GetMapping("/view")
    public String displayCalendar(Model model) {
        model.addAttribute("schedule", this.model.getSchedule());
        return "calendar-view"; // Thymeleaf template to display the calendar
    }

    @PostMapping("/add")
    public String addProjectToCalendar(@RequestParam String projectName, @RequestParam String interval, Model model) {
        Project project = new Project(1, projectName, "N/A", interval); // Simplified project creation
        this.model.addProjectSchedule(project, interval);

        model.addAttribute("message", "Project added to calendar successfully!");
        model.addAttribute("schedule", this.model.getSchedule());
        return "calendar-view"; // Redirect back to the calendar view
    }
}

