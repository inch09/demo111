package com.example.demo;

public class Club {
    private int id;
    private String nazvanie;
    private String opisanie;

    public Club(int id, String nazvanie, String opisanie) {
        this.id = id;
        this.nazvanie = nazvanie;
        this.opisanie = opisanie;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOpisanie() {
        return opisanie;
    }

    public void setOpisanie(String opisanie) {
        this.opisanie = opisanie;
    }

    public String getNazvanie() {
        return nazvanie;
    }

    public void setNazvanie(String nazvanie) {
        this.nazvanie = nazvanie;
    }
}
