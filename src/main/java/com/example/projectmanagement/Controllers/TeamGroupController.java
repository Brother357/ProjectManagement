package com.example.projectmanagement.Controllers;

import com.example.projectmanagement.Model.TeamGroup;
import com.example.projectmanagement.Model.Project;
import com.example.projectmanagement.Model.Employee;
import com.example.projectmanagement.View.TeamGroupView;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/team-group")
public class TeamGroupController {
    private List<TeamGroup> teamGroups;

    public TeamGroupController() {
        this.teamGroups = new ArrayList<>();
        TeamGroup defaultGroup = new TeamGroup(1, "Default Team Group");
        this.teamGroups.add(defaultGroup);
    }

    @GetMapping("/view")
    public String displayTeamGroups(Model model) {
        model.addAttribute("teamGroups", this.teamGroups);
        return "team-group-view"; // Thymeleaf template to display team groups
    }

    @PostMapping("/add")
    public String addTeamGroup(@RequestParam String name, Model model) {
        int newId = teamGroups.size() + 1;
        TeamGroup newGroup = new TeamGroup(newId, name);
        teamGroups.add(newGroup);

        model.addAttribute("message", "Team Group added successfully!");
        model.addAttribute("teamGroups", this.teamGroups);
        return "team-group-view"; // Redirect back to the team groups view
    }
}
