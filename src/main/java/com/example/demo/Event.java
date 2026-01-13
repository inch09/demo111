package com.example.demo;

public class Event {
    private int id;
    private String date;
    private String time;
    private String nazvanie;
    private String opisanie;
    private int clubId;

    public Event(int id, String date, String time, String nazvanie, String opisanie, int clubId) {
        this.id = id;
        this.date = date;
        this.time = time;
        this.nazvanie = nazvanie;
        this.opisanie = opisanie;
        this.clubId = clubId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getNazvanie() {
        return nazvanie;
    }

    public void setNazvanie(String nazvanie) {
        this.nazvanie = nazvanie;
    }

    public String getOpisanie() {
        return opisanie;
    }

    public void setOpisanie(String opisanie) {
        this.opisanie = opisanie;
    }

    public int getClubId() {
        return clubId;
    }

    public void setClubId(int clubId) {
        this.clubId = clubId;
    }
}
