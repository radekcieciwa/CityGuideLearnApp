package com.bearddev.cityguide.model.dummy;

import com.bearddev.cityguide.model.Place;
import com.bearddev.cityguide.model.Route;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by radek on 22.05.15.
 */
public class DummyRouteGenerator
{
    static String[] NAMES = {
            "Breakfast route",
            "Lost survivor",
            "Polish kings",
    };

    static String[] DESCRIPTIONS = {
            "The best route that will make you chill",
            "Route that will give you goosebumps",
            "Nothing special, just food!",
    };


    public static Route randomRoute(Long routeID)
    {
        Random rand = new Random();
        String name = NAMES[rand.nextInt(NAMES.length)];
        String description = DESCRIPTIONS[rand.nextInt(DESCRIPTIONS.length)];
        Route route = new Route(name, description);
        return route;
    }

    public static List<Route> randomRoutes(int count, boolean shouldAddId) {
        List<Route> routes = new ArrayList<>(count);
        for (long i = 0 ; i < count ; i ++) {
            Long id = shouldAddId ? i : null;
            routes.add(randomRoute(id));
        }

        return routes;
    }
}
