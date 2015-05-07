package com.bearddev.cityguide.model;

/**
 * Created by radek on 29.04.15.
 */
public class Place
{
    private Integer id;
    private String name;
    private String description;
    private String type;

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Place(Integer id, String name, String description, String type) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.type = type;
    }

    public Integer getId() {
        return id;
    }
}
