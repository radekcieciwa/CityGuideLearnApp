package com.bearddev.cityguide.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by radek on 29.04.15.
 */
@DatabaseTable(tableName = "places")
public class Place
{
    @DatabaseField(generatedId = true)
    private Long id;

    @DatabaseField(columnName = "name", canBeNull = false)
    private String name;

    @DatabaseField(columnName = "description")
    private String description;

    @DatabaseField(columnName = "image_url")
    private String imageURL;

    @DatabaseField(columnName = "rating")
    private Float rating; // <0,1>

    @DatabaseField(columnName = "lat")
    private Double latitude;

    @DatabaseField(columnName = "lon")
    private Double longitude;

    public Place () { }

    public Place(Long id, String name, String description, String imageURL, Float rating, Double latitude, Double longitude) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.imageURL = imageURL;
        this.rating = rating;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getImageURL() {
        return imageURL;
    }

    public Float getRating() {
        return rating;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }
}
