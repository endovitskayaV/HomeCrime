package vsu.ru.homecrime.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class DataKeeper {
    private static DataKeeper newInstance;
    private static List<Crime> crimesList;

    private DataKeeper() {
    }

    public static DataKeeper getNewInstance() {
        if (newInstance != null) return newInstance;
        else {
            crimesList = new ArrayList<>();
            crimesList.add(new Crime("Murder1", "Description1",
                    new GregorianCalendar(2014, Calendar.FEBRUARY, 1).getTime(), true));
            crimesList.add(new Crime("Murder2", "Description2",
                    new GregorianCalendar(2014, Calendar.FEBRUARY, 2).getTime()));
            crimesList.add(new Crime("Murder3", "Description3",
                    new GregorianCalendar(2014, Calendar.FEBRUARY, 3).getTime(), true));
            crimesList.add(new Crime("Murder4", "Description4",
                    new GregorianCalendar(2014, Calendar.FEBRUARY, 4).getTime()));
            crimesList.add(new Crime("Murder5", "Description5",
                    new GregorianCalendar(2014, Calendar.FEBRUARY, 5).getTime(), true));
            crimesList.add(new Crime("Murder6", "Description6",
                    new GregorianCalendar(2014, Calendar.FEBRUARY, 6).getTime()));
            crimesList.add(new Crime("Murder7", "Description7",
                    new GregorianCalendar(2014, Calendar.FEBRUARY, 7).getTime(), true));
            crimesList.add(new Crime("Murder8", "Description8",
                    new GregorianCalendar(2014, Calendar.FEBRUARY, 8).getTime(), true));
            crimesList.add(new Crime("Murder9", "Description9",
                    new GregorianCalendar(2014, Calendar.FEBRUARY, 9).getTime()));
            crimesList.add(new Crime("Murder10", "Description10",
                    new GregorianCalendar(2014, Calendar.FEBRUARY, 10).getTime()));
            crimesList.add(new Crime("Murder11", "Description11",
                    new GregorianCalendar(2014, Calendar.FEBRUARY, 11).getTime()));
            crimesList.add(new Crime("Murder12", "Description12",
                    new GregorianCalendar(2014, Calendar.FEBRUARY, 12).getTime()));
            crimesList.add(new Crime("Murder13", "Description13",
                    new GregorianCalendar(2014, Calendar.FEBRUARY, 13).getTime(), true));
            newInstance = new DataKeeper();
            return newInstance;
        }
    }

    public List<Crime> getCrimeList() {
        return crimesList;
    }
}
