package com.bearddev.cityguide;

import android.app.Application;

import com.bearddev.cityguide.interfaces.IPlaceRepository;
import com.bearddev.cityguide.model.repositories.DataBaseRepository;
import com.bearddev.cityguide.model.repositories.DummyPlaceRepository;

/**
 * Created by radek on 22.05.15.
 */
public class CityGuideApplication extends Application {

    private IPlaceRepository placeRepository = null;

    @Override
    public void onCreate() {
        super.onCreate();

        placeRepository = new DataBaseRepository(this);
    }

    public IPlaceRepository getPlaceRepository() {
        return placeRepository;
    }
}
