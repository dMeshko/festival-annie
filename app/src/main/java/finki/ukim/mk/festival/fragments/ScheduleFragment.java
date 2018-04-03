package finki.ukim.mk.festival.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Collections;

import finki.ukim.mk.festival.MainActivity;
import finki.ukim.mk.festival.R;
import finki.ukim.mk.festival.models.Artist;

/**
 * Created by Darrk on 4/3/2018.
 */

public class ScheduleFragment extends Fragment {
    public ScheduleFragment(){

    }

    public static ScheduleFragment newInstance(){
        ScheduleFragment fragment = new ScheduleFragment();
        Bundle args = new Bundle();
        //args.putInt("listings", listings);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.view_schedule_fragment, container, false);

        return view;
    }
}
