package controllers;

import models.Reading;
import models.Station;
import play.Logger;
import play.mvc.Controller;

import java.util.List;

public class Dashboard extends Controller
{
  public static void index()
  {
    Logger.info("Rendering Dashboard");
    List<Station> stations = Station.findAll();
    render("dashboard.html", stations);
  }

  public static void addStation(String name, double lat, double lng)
  {
    Station stations = new Station(name, lat, lng);
    stations.save();
    Logger.info("Addint Station" + name);
    redirect("/dashboard");
  }

  public static void deleteStation(Long id)
  {
    Station stations = Station.findById(id);
    stations.delete();
    Logger.info("Deleting " + stations.name);
    redirect("/dashboard");
  }
}
