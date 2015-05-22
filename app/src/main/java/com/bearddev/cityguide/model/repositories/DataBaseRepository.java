package com.bearddev.cityguide.model.repositories;

import android.content.Context;

import com.bearddev.cityguide.interfaces.IPlaceRepository;
import com.bearddev.cityguide.model.Place;
import com.bearddev.cityguide.model.vendors.ORMLiteHelper;

/**
 * Created by radek on 13.05.15.
 */
public class DataBaseRepository implements IPlaceRepository
{
    private ORMLiteHelper helper;

    public DataBaseRepository(Context context) {
        helper = new ORMLiteHelper(context);
    }

    @Override
    public void getPlaces(OnPlacesReturned listener) {
        if (listener != null) {
            listener.onCompletion(helper.getPlaceDao().queryForAll());
        }
    }

    @Override
    public Place getPlaceByID(Long placeID) {
        Place place = helper.getPlaceDao().queryForId(placeID.intValue());
        return place;
    }
}
