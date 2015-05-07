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
        places.add(new Place(1, "Wierzynek", "Pyszna polska restauracja", "Resto"));
        places.add(new Place(2, "Szwagier", "Pyszna polska restauracja", "Resto"));
        places.add(new Place(3, "Mac", "Pyszna polska restauracja", "Resto"));
        places.add(new Place(4, "KFC", "Pyszna polska restauracja", "Resto"));
        places.add(new Place(5, "Subway", "Pyszna polska restauracja", "Resto"));
        places.add(new Place(6, "Sukiennice", "Pyszna polska restauracja", "Resto"));
        places.add(new Place(7, "Grodza", "Pyszna polska restauracja", "Resto"));
        places.add(new Place(8, "Zapiekanki na placu nowy", "Pyszna polska restauracja", "Resto"));
        places.add(new Place(9, "Plac Inwalidow", "Pyszna polska restauracja", "Resto"));
        places.add(new Place(10, "Pradnik Czerwony", "Pyszna polska restauracja", "Resto"));

        return places;
    }

    public Place getPlaceByID(Integer placeID) {
        return new Place(10, "Pradnik Czerwony", "Pyszna polska restauracja", "Resto");
    }
}
