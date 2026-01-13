package com.example.demo;

public class Member {
    private int id;
    private String name;
    private String klass;
    private String pochta;

    public Member(int id, String name, String klass, String pochta) {
        this.id = id;
        this.name = name;
        this.klass = klass;
        this.pochta = pochta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKlass() {
        return klass;
    }

    public void setKlass(String klass) {
        this.klass = klass;
    }

    public String getPochta() {
        return pochta;
    }

    public void setPochta(String pochta) {
        this.pochta = pochta;
    }
}
