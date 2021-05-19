package controllers;

import models.Member;
import models.Station;
import play.Logger;
import play.mvc.Controller;

import java.util.List;

public class Accounts extends Controller {
    public static void signup() {
        render("signup.html");
    }

    public static void login() {
        render("login.html");
    }


    public static void index() {
        Logger.info("Rendering Profile");
        Member member = Accounts.getLoggedInMember();
        List<Station> stations = member.stations;
        render("profile.html", member, stations);
    }

    public static void register(String firstname, String lastname, String email, String password) {
        Logger.info("Registering new user " + email);
        Member member = new Member(firstname, lastname, email, password);
        member.save();
        redirect("/");
    }

    public static void authenticate(String email, String password) {
        Logger.info("Attempting to authenticate with " + email + ":" + password);

        Member member = Member.findByEmail(email);
        if ((member != null) && (member.checkPassword(password) == true)) {
            Logger.info("Authentication successful");
            session.put("logged_in_Memberid", member.id);
            redirect("/dashboard");
        } else {
            Logger.info("Authentication failed");
            redirect("/login");
        }
    }

    public static void logout() {
        session.clear();
        redirect("/");
    }

    public static Member getLoggedInMember() {
        Member member = null;
        if (session.contains("logged_in_Memberid")) {
            String memberId = session.get("logged_in_Memberid");
            member = Member.findById(Long.parseLong(memberId));
        } else {
            login();
        }
        return member;
    }

    public static void updateFirstName(String firstname) {
        Logger.info("Updating " + firstname);
        Member member = Accounts.getLoggedInMember();
        member.setFirstName(firstname);
        member.save();
        render("profile.html", member);
    }

    public static void updateLastName(String lastname) {
        Logger.info("Updating " + lastname);
        Member member = Accounts.getLoggedInMember();
        member.setLastName(lastname);
        member.save();
        render("profile.html", member);
    }

    public static void updateEmail(String email) {
        Logger.info("Updating " + email);
        Member member = Accounts.getLoggedInMember();
        member.setEmail(email);
        member.save();
        render("profile.html", member);
    }

    public static void updatePassword(String password) {
        Logger.info("Updating " + password);
        Member member = Accounts.getLoggedInMember();
        member.setPassword(password);
        member.save();
        render("profile.html", member);
    }
}