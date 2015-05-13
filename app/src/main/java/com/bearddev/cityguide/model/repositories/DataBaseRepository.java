package com.bearddev.cityguide.model.repositories;

import com.bearddev.cityguide.interfaces.IPlaceRepository;
import com.bearddev.cityguide.model.Place;

/**
 * Created by radek on 13.05.15.
 */
public class DataBaseRepository implements IPlaceRepository
{

    @Override
    public void getPlaces(OnPlacesReturned listener) {
        // TODO:
    }

    @Override
    public Place getPlaceByID(Long placeID) {
        // TODO:
        return null;
    }
}
