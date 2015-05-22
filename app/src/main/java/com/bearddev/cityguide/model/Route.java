package com.bearddev.cityguide.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by radek on 22.05.15.
 */

@DatabaseTable(tableName = "routes")
public class Route {

    @DatabaseField(generatedId = true)
    private Long id;

    @DatabaseField(columnName = "name")
    private String name;

    @DatabaseField(columnName = "description")
    private String description;

    @ForeignCollectionField()
    private List<RoutePlace> places;

    public Route() {
    }

    public Route(String name, String description) {
        this.name = name;
        this.description = description;
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

    public List<Place> getPlaces() {
        ArrayList<Place> listOfPlaces = new ArrayList<>(places.size());

        for (int i = 0 ; i < places.size() ; i++) {
            // TODO: !
        }

        return listOfPlaces;
    }
}
