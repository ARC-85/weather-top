package controllers;

import models.Member;
import models.Station;
import play.Logger;
import play.mvc.Controller;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Dashboard extends Controller {
    public static void index() {
        Logger.info("Rendering Dashboard");
        Member member = Accounts.getLoggedInMember();
        List<Station> stations = member.stations;
        Collections.sort(stations, Comparator.comparing(Station::getName));
        render("dashboard.html", member, stations);
    }

    public static void addStation(String name, double lat, double lng) {
        Member member = Accounts.getLoggedInMember();
        Station stations = new Station(name, lat, lng);
        member.stations.add(stations);
        member.save();
        Logger.info("Addint Station" + name);
        redirect("/dashboard");
    }

    public static void deleteStation(Long id, Long stationid) {
        Member member = Member.findById(id);
        Station stations = Station.findById(stationid);
        member.stations.remove(stations);
        member.save();
        stations.delete();
        Logger.info("Deleting " + stations.name);
        redirect("/dashboard");
    }
}
