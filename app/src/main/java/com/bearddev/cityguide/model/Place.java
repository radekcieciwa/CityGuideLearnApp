package com.bearddev.cityguide.model;

/**
 * Created by radek on 29.04.15.
 */
public class Place
{
    private Long id;
    private String name;
    private String description;
    private String imageURL;
    private String type;

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Place(Long id, String name, String description, String type) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.type = type;
        this.imageURL = "http://direct.infinitylist.com/wordpress2/wp-content/uploads/2013/01/ONeill-Girls-Surf-Team-North-Shore-Hawaii.jpg";
    }

    public String getImageURL() {
        return imageURL;
    }

    public Long getId() {
        return id;
    }
}
