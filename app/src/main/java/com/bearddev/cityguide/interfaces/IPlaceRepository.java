package com.bearddev.cityguide.interfaces;

import com.bearddev.cityguide.model.Place;

import java.util.List;

/**
 * Created by radek on 07.05.15.
 */
public interface IPlaceRepository
{
    public static interface OnPlacesReturned
    {
        public void onCompletion(List<Place> places);
        public void onFailed(String reason);
    }

    public void getPlaces(OnPlacesReturned listener);
    public Place getPlaceByID(Long placeID);
}
