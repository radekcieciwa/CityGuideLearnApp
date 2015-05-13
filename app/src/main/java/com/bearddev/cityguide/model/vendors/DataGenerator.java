package com.bearddev.cityguide.model.vendors;

import com.bearddev.cityguide.model.Place;
import com.bearddev.cityguide.model.repositories.DummyPlaceGenerator;
import com.j256.ormlite.dao.RuntimeExceptionDao;

import java.util.List;

/**
 * Created by radek on 13.05.15.
 */
public class DataGenerator
{
    public static void generateEntries(RuntimeExceptionDao<Place, Integer> placeDao, int count) {
        List<Place> places = DummyPlaceGenerator.randomPlaces(10, false);
        for (int i = 0 ; i < places.size() ; i++) {
            Place place = places.get(i);
            placeDao.createIfNotExists(place);
        }
    }
}
