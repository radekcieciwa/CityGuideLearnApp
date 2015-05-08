package com.bearddev.cityguide.cells;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bearddev.cityguide.R;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by radek on 29.04.15.
 */
public class PlaceListCell extends LinearLayout
{
    @InjectView(R.id.c_pl_image)
    ImageView imageIV;

    @InjectView(R.id.c_pl_title)
    TextView titleTV;

    public PlaceListCell(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        ButterKnife.inject(this, this);
    }

    public ImageView getImageIV() {
        return imageIV;
    }

    public TextView getTitleTV() {
        return titleTV;
    }
}
