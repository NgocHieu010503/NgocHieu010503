package com.Hieucompany.bundesliga.model;

public class Fixture {
    private String home;
    private String away;
    private String date;
    private String result;

    public Fixture(String home, String away, String date) {
        this.home = home;
        this.away = away;
        this.date = date;
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public String getAway() {
        return away;
    }

    public void setAway(String away) {
        this.away = away;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
