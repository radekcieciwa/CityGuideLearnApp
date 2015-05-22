package com.bearddev.cityguide.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by radek on 22.05.15.
 */
@DatabaseTable(tableName = "route_place")
public class RoutePlace {

    @DatabaseField(generatedId = true)
    private Long id;

    @DatabaseField(foreign = true, columnName = "route_id")
    private Route route;

    @DatabaseField(foreign = true, columnName = "place_id")
    private Place place;

    public RoutePlace() {
    }

    public Route getRoute() {
        return route;
    }

    public Place getPlace() {
        return place;
    }

    public RoutePlace(Route route, Place place) {
        this.route = route;
        this.place = place;
    }
}
