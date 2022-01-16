package com.example.projettroc.Database;

public class Annonce {
    private int id;
    private  String name;
    private String image;
   private String description;




    public Annonce(String name, String description){}

    public Annonce(int id, String name, String image,String description) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.description=description;
    }

    public Annonce(String name, String image,String description) {
        this.name = name;
        this.image = image;
        this.description=description;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
