package me.jayeshbhadja.ganttchartlibrary.model;

/**
 * Created by Jayesh Bhadja on 04-10-17.
 */

public class Task {
    private String uuid;
    private String title;
    private String startDate;
    private String endDate;
    private String status;
    private String statusDate;
    private String percentageComplete;

    public Task() {
    }

    public Task(String uuid, String title, String startDate, String endDate, String status, String statusDate, String percentageComplete) {
        this.uuid = uuid;
        this.title = title;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
        this.statusDate = statusDate;
        this.percentageComplete = percentageComplete;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatusDate() {
        return statusDate;
    }

    public void setStatusDate(String statusDate) {
        this.statusDate = statusDate;
    }

    public String getPercentageComplete() {
        return percentageComplete;
    }

    public void setPercentageComplete(String percentageComplete) {
        this.percentageComplete = percentageComplete;
    }
}
