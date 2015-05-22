package com.bearddev.cityguide.model.dummy;

import com.bearddev.cityguide.model.Place;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by radek on 13.05.15.
 */
public class DummyPlaceGenerator
{
    static String[] NAMES = {
            "Wierzynek",
            "KFC",
            "Zakladka",
    };

    static String[] DESCRIPTIONS = {
            "Pyszna polska restauracja",
            "Fast food z kurczakami",
            "Francja elegancja",
    };

    static Float[] RATINGS = {
            0.6f,
            0.1f,
            1.0f,
    };

    static Double[][] COORDS = {
            { 49.22, 20.5 },
            { 49.21, 20.4 },
    };

    static String[] IMAGES = {
            "http://direct.infinitylist.com/wordpress2/wp-content/uploads/2013/01/ONeill-Girls-Surf-Team-North-Shore-Hawaii.jpg",
            "http://upload.wikimedia.org/wikipedia/commons/6/6f/Ristorante_dell'agnolo.JPG",
            "http://www.livignok.eu/Foto/Ristoranti/3/ristorante.jpg",
            "http://www.visailing.com/_images/bahamas-1.png",
    };

    public static Place randomPlace(Long placeID)
    {
        Random rand = new Random();
        String name = NAMES[rand.nextInt(NAMES.length)];
        String description = DESCRIPTIONS[rand.nextInt(DESCRIPTIONS.length)];
        String imageURL = IMAGES[rand.nextInt(IMAGES.length)];
        Float rating = RATINGS[rand.nextInt(RATINGS.length)];
        Double[] doubles = COORDS[rand.nextInt(COORDS.length)];
        Double lat = doubles[0];
        Double lon = doubles[1];
        Place place = new Place(placeID, name, description, imageURL, rating, lat, lon);
        return place;
    }

    public static List<Place> randomPlaces(int count, boolean shouldAddId) {
        List<Place> places = new ArrayList<>(count);
        for (long i = 0 ; i < count ; i ++) {
            Long id = shouldAddId ? i : null;
            places.add(randomPlace(id));
        }

        return places;
    }
}
