package com.bearddev.cityguide.interfaces;

import com.bearddev.cityguide.model.Place;

import java.util.List;

/**
 * Created by radek on 07.05.15.
 */
public interface IPlaceRepository
{
    public List<Place> getPlaces();
    public Place getPlaceByID(Integer placeID);
}
