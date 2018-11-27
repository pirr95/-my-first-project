package ru.future.scientist.myfirstproject;

import java.util.Objects;

public class Task {
    private long id;
    private String name;
    private String description;
    private int time;
    private boolean completed;


    public Task( String name, String description, int time, boolean completed) {
       this(0, name, description,time, completed);

    }

    public Task(long id, String name, String description, int time, boolean completed) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.time = time;
        this.completed = completed;

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return id == task.id &&
                time == task.time &&
                completed == task.completed &&
                Objects.equals(name, task.name) &&
                Objects.equals(description, task.description);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, description, time, completed);
    }

}
