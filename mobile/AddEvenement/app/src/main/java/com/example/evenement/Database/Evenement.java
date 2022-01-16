package com.example.evenement.Database;

public class Evenement {

    private int id;
    private String name;
    private String Date;
    private String temps;

    public Evenement(int id, String name, String date, String temps) {
        this.id = id;
        this.name = name;
        Date = date;
        this.temps = temps;
    }

    public Evenement(String name, String date, String temps) {
        this.name = name;
        Date = date;
        this.temps = temps;
    }

    public Evenement() {
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Evenement{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", Date='" + Date + '\'' +
                ", temps='" + temps + '\'' +
                '}';
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

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getTemps() {
        return temps;
    }

    public void setTemps(String temps) {
        this.temps = temps;
    }
}
