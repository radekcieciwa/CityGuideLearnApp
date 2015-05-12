package com.bearddev.cityguide.adapters;

/**
 * Created by radek on 29.04.15.
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.androidquery.AQuery;
import com.androidquery.util.AQUtility;
import com.bearddev.cityguide.R;
import com.bearddev.cityguide.cells.PlaceListCell;
import com.bearddev.cityguide.model.Place;
import com.squareup.picasso.Picasso;

public class PlaceAdapter<T extends Place> extends ArrayAdapter<T>
{
    public PlaceAdapter(Context context, int resource) {
        super(context, resource);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        PlaceListCell placeListCell = (PlaceListCell) convertView;

        if (placeListCell == null) {
            LayoutInflater li = LayoutInflater.from(getContext());
            placeListCell = (PlaceListCell) li.inflate(R.layout.c_place_list, null);
        }

        Place place = getItem(position);
        String name = place.getName();
        placeListCell.getTitleTV().setText(name);
        placeListCell.getDistanceTV().setText(place.getDistance() + "km");
        placeListCell.getDescriptionTV().setText(place.getDescription());

        String imageURL = place.getImageURL();
        ImageView imageView = placeListCell.getImageIV();
        Picasso.with(getContext()).load(imageURL).into(imageView);

        return placeListCell;
    }

    @Override
    public long getItemId(int position)
    {
        Place place = getItem(position);
        return place.getId();
    }
}
