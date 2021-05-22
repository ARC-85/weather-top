package controllers;

import models.Reading;
import models.Station;
import models.Member;
import play.Logger;
import play.mvc.Controller;

import java.util.List;

public class Admin extends Controller {
    public static void index() {
        Logger.info("Rendering Admin");
        List<Reading> readings = Reading.findAll();
        List<Station> stations = Station.findAll();
        List<Member> members = Member.findAll();
        render("admin.html", readings, stations, members);
    }
}
