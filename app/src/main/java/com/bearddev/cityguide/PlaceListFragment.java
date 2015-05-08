package com.bearddev.cityguide;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.bearddev.cityguide.adapters.PlaceAdapter;
import com.bearddev.cityguide.model.Place;
import com.bearddev.cityguide.repositories.PlaceRepository;

import java.util.List;

/**
 * Created by radek on 29.04.15.
 */
public class PlaceListFragment extends Fragment implements AdapterView.OnItemClickListener
{
    protected ListView listView;
    private PlaceAdapter<Place> placeAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.f_place_list, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        listView = (ListView) view.findViewById(R.id.f_pl_list_view);
        
        setup();
        requestForData();
    }

    private void setup() {
        setupListView();
    }

    private void setupListView() {
        placeAdapter = new PlaceAdapter<>(this.getActivity(), R.layout.c_place_list);
        listView.setAdapter(placeAdapter);
        listView.setOnItemClickListener(this);
    }

    private void requestForData() {
        requestForDummyData();
    }

    private void requestForDummyData() {
        List<Place> placeList = new PlaceRepository().getPlaces();
        placeAdapter.addAll(placeList);
        placeAdapter.notifyDataSetChanged();
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id)
    {
        PlaceDetailFragment placeDetailFragment = createPlaceFragmentWithID(id);
        ((MainActivity) getActivity()).pushFragment(placeDetailFragment, "PLACE:DETAILS");
    }

    private PlaceDetailFragment createPlaceFragmentWithID(long id) {
        PlaceDetailFragment placeDetailFragment = new PlaceDetailFragment();
        Bundle bundle = new Bundle();
        bundle.putLong(PlaceDetailFragment.PLACE_ID, id);
        placeDetailFragment.setArguments(bundle);
        return placeDetailFragment;
    }
}
