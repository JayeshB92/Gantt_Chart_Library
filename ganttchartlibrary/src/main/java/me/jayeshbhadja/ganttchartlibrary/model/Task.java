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

    /**
     * No args constructor for use in serialization
     */
    public Task() {
    }

    /**
     * Parametrised Constructor to set object data
     *
     * @param uuid               Unique identification of record
     * @param title              Task Title
     * @param startDate          Task Starting date
     *                           FORMAT: yyyy-mm-dd
     * @param endDate            Task Ending date
     *                           FORMAT: yyyy-mm-dd
     * @param status             Task status i.e. Cancelled, On Hold, Delayed, Before Time, On Track, Completed
     * @param statusDate         Date when status is updated
     *                           FORMAT: yyyy-mm-dd
     * @param percentageComplete Task Completion in % e.g. 46 in percentage
     */
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

    /**
     * Setter for Task's Title
     * @param title
     * Task Title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    public String getStartDate() {
        return startDate;
    }

    /**
     * Setter for Task's Starting date
     * @param startDate
     * Task Starting date
     * FORMAT: yyyy-mm-dd
     */
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    /**
     * Setter for Task's Ending date
     * @param endDate
     * Task Ending date
     * FORMAT: yyyy-mm-dd
     */
    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getUuid() {
        return uuid;
    }

    /**
     * Setter for Task uuid
     *
     * @param uuid
     * Unique Identification of Task
     * value: alphanumeric
     */
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getStatus() {
        return status;
    }

    /**
     * Setter for Task's Status
     * @param status
     * Task status i.e. Cancelled, On Hold, Delayed, Before Time, On Track, Completed
     */
    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatusDate() {
        return statusDate;
    }

    /**
     * Setter for Task's Status updated date
     * @param statusDate
     * Task Status updated date
     * FORMAT: yyyy-mm-dd
     */
    public void setStatusDate(String statusDate) {
        this.statusDate = statusDate;
    }

    public String getPercentageComplete() {
        return percentageComplete;
    }

    /**
     * Setter for Task's Percentage Completed on Status Updated
     * @param percentageComplete
     * Task Completion in percentage(%) e.g. 46 in percentage
     */
    public void setPercentageComplete(String percentageComplete) {
        this.percentageComplete = percentageComplete;
    }
}
