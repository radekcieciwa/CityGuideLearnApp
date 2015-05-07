package com.bearddev.cityguide.adapters;

/**
 * Created by radek on 29.04.15.
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.bearddev.cityguide.R;
import com.bearddev.cityguide.cells.PlaceListCell;
import com.bearddev.cityguide.model.Place;

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
        String description = place.getDescription();

        placeListCell.getTitleTV().setText(name);
        placeListCell.getDescriptionTV().setText(description);
        placeListCell.getImageIV().setImageResource(R.drawable.icon);
        return placeListCell;
    }

    @Override
    public long getItemId(int position)
    {
        Place place = getItem(position);
        return place.getId();
    }
}
