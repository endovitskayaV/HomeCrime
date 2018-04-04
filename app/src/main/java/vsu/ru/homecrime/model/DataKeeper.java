package vsu.ru.homecrime.model;

import android.provider.ContactsContract;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DataKeeper {
    private static DataKeeper newInstance;
    private static List<Crime> crimesList;

    private DataKeeper() {
    }

    public static DataKeeper getNewIntance() {
        if (newInstance != null) return newInstance;
        else {
            crimesList=new ArrayList<>();
            crimesList.add(new Crime("Title", "", new Date()));
            crimesList.add(new Crime("", "", new Date()));
            crimesList.add(new Crime("", "", new Date()));
            crimesList.add(new Crime("", "", new Date()));
            crimesList.add(new Crime("", "", new Date()));
            return new DataKeeper();
        }
    }

    public List<Crime> getCrimeList() {
        return crimesList;
    }
}
