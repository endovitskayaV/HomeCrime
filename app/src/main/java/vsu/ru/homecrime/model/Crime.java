package vsu.ru.homecrime.model;

import java.io.Serializable;
import java.util.Date;

public class Crime implements Serializable{
    private int id;
    private String title;
    private String description;
    private Date date;
    private boolean isSolved;

    private static int counter = 0;

    public Crime(String title, String description, Date date) {
        id = generateId();
        this.title = title;
        this.description = description;
        this.date = date;
        isSolved = false;
    }

    public Crime(String title, String description, Date date, boolean isSolved) {
        id = generateId();
        this.title = title;
        this.description = description;
        this.date = date;
        this.isSolved = isSolved;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Date getDate() {
        return date;
    }

    public boolean isSolved() {
        return isSolved;
    }

    public Crime setTitle(String title) {
        this.title = title;
        return this;
    }

    public Crime setDescription(String description) {
        this.description = description;
        return this;
    }

    public Crime setDate(Date date) {
        this.date = date;
        return this;
    }

    public Crime setSolved(boolean solved) {
        isSolved = solved;
        return this;
    }

    private int generateId() {
        return counter++;
    }
}
