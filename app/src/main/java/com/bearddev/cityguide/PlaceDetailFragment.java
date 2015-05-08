package com.bearddev.cityguide;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.androidquery.AQuery;
import com.bearddev.cityguide.model.Place;
import com.bearddev.cityguide.repositories.PlaceRepository;

import org.w3c.dom.Text;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by radek on 07.05.15.
 */
public class PlaceDetailFragment extends Fragment
{
//    TBD like: AirBnB
// http://pttrns.com/applications/424
    public static final String PLACE_ID = "PLACE_ID";

    @InjectView(R.id.f_pd_title_tv)
    TextView titleTextView;

    @InjectView(R.id.f_pd_description_tv)
    TextView descriptionTextView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.f_place_details, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.inject(this, view);

        Long placeID = getArguments().getLong(PLACE_ID);
        Place place = new PlaceRepository().getPlaceByID(placeID);
        populateControlersWithPlace(place);
    }

    private void populateControlersWithPlace(Place place) {
        titleTextView.setText(place.getName());
        descriptionTextView.setText(place.getDescription());
        AQuery aQuery = new AQuery(getActivity());
        aQuery.id(R.id.f_pd_image_iv).image(place.getImageURL());
    }
}
