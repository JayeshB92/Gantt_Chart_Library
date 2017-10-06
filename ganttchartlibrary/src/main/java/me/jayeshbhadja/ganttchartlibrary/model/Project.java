package me.jayeshbhadja.ganttchartlibrary.model;

/**
 * Created by Jayesh Bhadja on 04-10-17.
 */

public class Project {
    private String name;
    private String startDate;
    private String endDate;
    private String uuid;

    /**
     * No args constructor for use in serialization
     */
    public Project() {
    }

    /**
     * Parametrised Constructor to set object data
     *
     * @param uuid      Unique Identification of Project
     *                  value: alphanumeric
     * @param name      Name of project
     * @param startDate Starting date of project
     *                  FORMAT: yyyy-mm-dd
     * @param endDate   Ending date of project
     *                  FORMAT: yyyy-mm-dd
     */
    public Project(String uuid, String name, String startDate, String endDate) {
        this.uuid = uuid;
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getName() {
        return name;
    }

    /**
     * Setter for project name
     *
     * @param name
     * name of project
     */
    public void setName(String name) {
        this.name = name;
    }

    public String getStartDate() {
        return startDate;
    }

    /**
     * Setter for project starting date
     *
     * @param startDate
     * Starting date of project
     * FORMAT: yyyy-mm-dd
     */
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    /**
     * Setter for project ending date
     *
     * @param endDate
     * Ending date of project
     * FORMAT: yyyy-mm-dd
     */
    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getUuid() {
        return uuid;
    }

    /**
     * Setter for project uuid
     *
     * @param uuid
     * Unique Identification of Project
     * value: alphanumeric
     */
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}
