package com.bearddev.cityguide.model.dummy;

import com.bearddev.cityguide.model.Place;
import com.bearddev.cityguide.model.Route;

/**
 * Created by radek on 22.05.15.
 */
public class ObjectFactory
{
    public static <T> T createDummy(Class<T> clazz) {
        if (clazz == Place.class) {
            return (T)DummyPlaceGenerator.randomPlace(null);
        }
        else if (clazz == Route.class) {
            return (T)DummyRouteGenerator.randomRoute(null);
        }
        else {
            throw new RuntimeException("Class not defined in ObjectFactory");
        }
    }
}
