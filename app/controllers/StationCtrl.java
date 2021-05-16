package controllers;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import models.Station;
import models.Reading;
import play.Logger;
import play.mvc.Controller;

public class StationCtrl extends Controller
{
    public static void index(Long id)
    {
        Station station = Station.findById(id);
        Logger.info ("Station id = " + id);
        render("station.html", station);
    }
    public static void deletereading (Long id, Long readingid)
    {
        Station station = Station.findById(id);
        Reading reading = Reading.findById(readingid);
        Logger.info ("Removing Reading id = " + readingid);
        station.readings.remove(reading);
        station.save();
        reading.delete();
        render("station.html", station);
    }

    public static void addReading(Long id, int code, double temperature, double windSpeed, double windDirection, int pressure)
    {
        Station station = Station.findById(id);
        Date time = new Date();
        Reading readings = new Reading(time, code, temperature, windSpeed, windDirection, pressure);
        readings.save();
        Logger.info("Addint Reading" + code);
        station.readings.add(readings);
        station.save();
        render("station.html", station);

    }
}
