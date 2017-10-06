package me.jayeshbhadja.ganttchartlibrary.model;

/**
 * Created by Jayesh Bhadja on 04-10-17.
 */

public class Milestone {

    private String title;
    private String deadline;
    private String uuid;

    /**
     * No args constructor for use in serialization
     */
    public Milestone() {
    }

    /**
     * Parametrised Constructor to set object data
     *
     * @param uuid
     * String uuid for unique identification of record
     * @param title
     * String Title of milestone to display on date
     * @param deadline
     * String deadline for milestone to be achieved
     * FORMAT: yyyy-mm-dd
     */
    public Milestone(String uuid, String title, String deadline) {
        super();
        this.uuid = uuid;
        this.title = title;
        this.deadline = deadline;
    }

    public String getTitle() {
        return title;
    }

    /**
     * Setter for title of milestone
     *
     * @param title milestone title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    public String getDeadline() {
        return deadline;
    }

    /**
     * Setter for milestone deadline
     *
     * @param deadline
     * String deadline for milestone to be achieved
     * FORMAT: yyyy-mm-dd
     */
    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public String getUuid() {
        return uuid;
    }

    /**
     * Setter for Milestone uuid
     *
     * @param uuid
     * Unique Identification of Milestone
     * value: alphanumeric
     */
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}
