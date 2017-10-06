package me.jayeshbhadja.ganttchartlibrary.model;

/**
 * Created by Jayesh Bhadja on 04-10-17.
 */

public class Milestone {

    private String title;
    private String deadline;
    private String uuid;
    private String status;

    /**
     * No args constructor for use in serialization
     */
    public Milestone() {
    }

    /**
     * @param uuid
     * @param title
     * @param deadline
     * @param status
     */
    public Milestone(String uuid, String title, String deadline, String status) {
        super();
        this.uuid = uuid;
        this.title = title;
        this.deadline = deadline;
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
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
}
