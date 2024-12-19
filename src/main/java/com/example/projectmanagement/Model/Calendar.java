package com.example.projectmanagement.Model;

import java.util.HashMap;
import java.util.Map;

public class Calendar {
    private Map<Project, String> schedule; // Maps projects to their time intervals

    public Calendar() {
        this.schedule = new HashMap<>();
    }

    public Map<Project, String> getSchedule() { return schedule; }
    public void addProjectSchedule(Project project, String interval) {
        this.schedule.put(project, interval);
    }
}
