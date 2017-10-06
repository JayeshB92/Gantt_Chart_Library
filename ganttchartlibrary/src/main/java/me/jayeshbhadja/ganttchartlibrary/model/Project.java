package me.jayeshbhadja.ganttchartlibrary.model;

/**
 * Created by Jayesh Bhadja on 04-10-17.
 */

public class Project {
    private String name;
    private String startDate;
    private String endDate;
    private String uuid;

    public Project() {
    }

    public Project(String uuid, String name, String startDate, String endDate) {
        this.uuid = uuid;
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}
