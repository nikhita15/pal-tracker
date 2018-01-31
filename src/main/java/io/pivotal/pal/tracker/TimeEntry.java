package io.pivotal.pal.tracker;

import java.sql.Time;
import java.time.LocalDate;

/**
 * Created by e052988 on 1/31/18.
 */
public class TimeEntry {
    private long id;
    private long projectId;
    private long userId;
    private LocalDate date;
    private int hours;

    public TimeEntry() {
    }

    public TimeEntry(long id, long projectId, long userId, LocalDate date, int hours) {
        this.id = id;
        this.projectId = projectId;
        this.userId = userId;
        this.date = date;
        this.hours =hours;
    }

    public TimeEntry(long projectId, long userId, LocalDate date, int hours) {
        this.projectId = projectId;
        this.userId = userId;
        this.date = date;
        this.hours =hours;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setProjectId(long projectId) {
        this.projectId = projectId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public long getId() {
        return id;
    }

    public long getProjectId() {
        return projectId;
    }

    public long getUserId() {
        return userId;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getHours() {
        return hours;
    }
}
