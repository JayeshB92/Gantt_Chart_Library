package me.jayeshbhadja.ganttchartlibrary.model;

import java.util.List;

/**
 * Created by Jayesh Bhadja on 5/10/17.
 */

public class GanttData {
    private static GanttData ganttData = null;
    private Project project;
    private List<Task> tasks;
    private List<Milestone> milestones;

    public static GanttData initGanttData(Project project, List<Task> tasks, List<Milestone> milestones) {
        ganttData = new GanttData();
        ganttData.setProject(project);
        ganttData.setTasks(tasks);
        ganttData.setMilestones(milestones);

        return ganttData;
    }

    public static GanttData getGanttData() {
        return ganttData;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public List<Milestone> getMilestones() {
        return milestones;
    }

    public void setMilestones(List<Milestone> milestones) {
        this.milestones = milestones;
    }

}
