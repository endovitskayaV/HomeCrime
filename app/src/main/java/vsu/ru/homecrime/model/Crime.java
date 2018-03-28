package vsu.ru.homecrime.model;

import java.util.Date;

public class Crime {
    private int id;
    private String title;
    private String description;
    private Date date;
    private boolean isSolved;

    public Crime(String title, String description, Date date) {
        id = generateId();
        this.title = title;
        this.description = description;
        this.date = date;
        isSolved = false;
    }

    private int generateId() {
        return 0;
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
}
