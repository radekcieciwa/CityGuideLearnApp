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
    private Double distance;

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Place(Long id, String name, String description, String imageURL, String type, Double distance) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.imageURL = imageURL;
        this.type = type;
        this.distance = distance;
    }

    public String getImageURL() {
        return imageURL;
    }

    public Long getId() {
        return id;
    }

    public Double getDistance() {
        return distance;
    }
}
