package com.example.projectmanagement.View;

import com.example.projectmanagement.Model.Calendar;

public class CalendarView {
    public void displayCalendar(Calendar calendar) {
        System.out.println("Project Schedule:");
        calendar.getSchedule().forEach((project, interval) ->
                System.out.println(project.getName() + ": " + interval));
    }
}
