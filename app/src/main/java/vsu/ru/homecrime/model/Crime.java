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

    private int generateId() {
        return counter++;
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

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setSolved(boolean solved) {
        isSolved = solved;
    }
}
