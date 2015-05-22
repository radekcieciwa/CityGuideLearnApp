package com.bearddev.cityguide.model.vendors;

import com.bearddev.cityguide.model.Place;
import com.bearddev.cityguide.model.Route;
import com.bearddev.cityguide.model.RoutePlace;
import com.bearddev.cityguide.model.dummy.DummyPlaceGenerator;
import com.bearddev.cityguide.model.dummy.DummyRouteGenerator;

import java.util.List;
import java.util.Random;

/**
 * Created by radek on 13.05.15.
 */
public class DataGenerator
{
    public static void generatePlaces(ORMLiteHelper ormLiteHelper, int count) {
        List<Place> places = DummyPlaceGenerator.randomPlaces(count, false);
        for (int i = 0 ; i < places.size() ; i++) {
            Place place = places.get(i);
            ormLiteHelper.getPlaceDao().createIfNotExists(place);
        }
    }

    public static void generateRoutes(ORMLiteHelper ormLiteHelper, int count) {
        List<Route> routes = DummyRouteGenerator.randomRoutes(count, false);
        for (int i = 0 ; i < routes.size() ; i++) {
            Route route = routes.get(i);
            ormLiteHelper.getRouteDao().createIfNotExists(route);
        }
    }

    public static void generatePlaceAssociationsForEachRoute(ORMLiteHelper ormLiteHelper, int connections) {
        List<Route> routes = ormLiteHelper.getRouteDao().queryForAll();

        for (int i = 0 ; i < routes.size() ; i++) {
            Route route = routes.get(i);

            List<Place> places = ormLiteHelper.getPlaceDao().queryForAll();
            Random rand = new Random();

            for (int j = 0 ; j < connections ; j++) {
                int placeIndex = rand.nextInt(places.size());
                Place place = places.get(placeIndex);
                RoutePlace rp = new RoutePlace(route, place);
                ormLiteHelper.getRoutePlaceDao().createIfNotExists(rp);
            }
        }
    }
}
