package com.bearddev.cityguide.repositories;

import com.bearddev.cityguide.model.Place;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by radek on 29.04.15.
 */
public class PlaceRepository
{
    public static interface OnPlacesReturned
    {
        public void onCompletion(List<Place> places);
        public void onFailed(String reason);
    }

    private List<Place> createDummyPlaces()
    {
        List<Place> places = new ArrayList<Place>(10);
        places.add(new Place(1l,
                "Wierzynek",
                "Pyszna polska restauracja",
                "http://direct.infinitylist.com/wordpress2/wp-content/uploads/2013/01/ONeill-Girls-Surf-Team-North-Shore-Hawaii.jpg",
                "Restaurant",
                12.4
        ));

        places.add(new Place(2l,
                "KFC",
                "Fast food z kurczakami",
                "http://upload.wikimedia.org/wikipedia/commons/6/6f/Ristorante_dell'agnolo.JPG",
                "Fast-Food",
                1.0
        ));

        places.add(new Place(3l,
                "Zakladka",
                "Francja elegancja",
                "http://www.livignok.eu/Foto/Ristoranti/3/ristorante.jpg",
                "Restaurant",
                2.3
        ));
        return places;
    }

    public void getPlaces(OnPlacesReturned listener)
    {
        List<Place> places = createDummyPlaces();

        if (listener != null) {
            listener.onCompletion(places);
        }
    }

    public Place getPlaceByID(Long placeID)
    {
        for (Place place : createDummyPlaces()) {
            if (place.getId() == placeID) {
                return place;
            }
        }

        return null;
    }
}
