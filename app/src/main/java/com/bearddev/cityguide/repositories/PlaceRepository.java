package com.bearddev.cityguide.repositories;

import com.bearddev.cityguide.model.Place;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by radek on 29.04.15.
 */
public class PlaceRepository
{
    public List<Place> getPlaces()
    {
        List<Place> places = new ArrayList<Place>(10);
        places.add(new Place(1l, "Wierzynek", "Pyszna polska restauracja", "Resto"));
        places.add(new Place(2l, "Szwagier", "Pyszna polska restauracja", "Resto"));
        places.add(new Place(3l, "Mac", "Pyszna polska restauracja", "Resto"));
        places.add(new Place(4l, "KFC", "Pyszna polska restauracja", "Resto"));
        places.add(new Place(5l, "Subway", "Pyszna polska restauracja", "Resto"));
        places.add(new Place(6l, "Sukiennice", "Pyszna polska restauracja", "Resto"));
        places.add(new Place(7l, "Grodza", "Pyszna polska restauracja", "Resto"));
        places.add(new Place(8l, "Zapiekanki na placu nowy", "Pyszna polska restauracja", "Resto"));
        places.add(new Place(9l, "Plac Inwalidow", "Pyszna polska restauracja", "Resto"));
        places.add(new Place(10l, "Pradnik Czerwony", "Pyszna polska restauracja", "Resto"));

        return places;
    }

    public Place getPlaceByID(Long placeID) {
        return new Place(10l, "Pradnik Czerwony", "Pyszna polska restauracja", "Resto");
    }
}
