package com.bearddev.cityguide.model.repositories;

import com.bearddev.cityguide.interfaces.IPlaceRepository;
import com.bearddev.cityguide.model.Place;

import java.util.List;

/**
 * Created by radek on 29.04.15.
 */
public class DummyPlaceRepository implements IPlaceRepository
{
    private List<Place> dummyPlaces;

    public DummyPlaceRepository() {
        dummyPlaces = DummyPlaceGenerator.randomPlaces(12, true);
    }

    public void getPlaces(OnPlacesReturned listener)
    {
        if (listener != null) {
            listener.onCompletion(dummyPlaces);
        }
    }

    public Place getPlaceByID(Long placeID)
    {
        for (Place place : dummyPlaces) {
            if (place.getId() == placeID) {
                return place;
            }
        }

        return null;
    }
}
