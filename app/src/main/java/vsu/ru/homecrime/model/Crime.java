package vsu.ru.homecrime.model;

import java.util.Date;

public class Crime {
    private int id;
    private String description;
    private Date date;
    private boolean isSolved;

    public Crime(String description, Date date){
        id=generateId();
        this.description=description;
        this.date=date;
        isSolved=false;
    }

    private int generateId(){
        return 0;
    }

    public int getId() {
        return id;
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
