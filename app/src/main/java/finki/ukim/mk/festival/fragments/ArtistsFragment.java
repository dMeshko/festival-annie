package finki.ukim.mk.festival.fragments;

import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import finki.ukim.mk.festival.MainActivity;
import finki.ukim.mk.festival.R;
import finki.ukim.mk.festival.models.Artist;
import finki.ukim.mk.festival.utilities.ListViewAdapter;

public class ArtistsFragment extends ListFragment {
    private List<Artist> artists;
    private boolean userScrolled;
    private int offset;
    private int end;
    private ListView listView;

    public ArtistsFragment(){
        artists = new ArrayList<Artist>();
    }

    public static ArtistsFragment newInstance(){
        ArtistsFragment fragment = new ArtistsFragment();
        Bundle args = new Bundle();
        //args.putInt("listings", listings);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            //active = getArguments().getInt("active");
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.view_artists_fragment, container, false);

        artists = MainActivity.artists;
        // todo: sortiraj annie
        Collections.sort(artists);

        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        listView = getListView();
        ListViewAdapter listingsAdapter = new ListViewAdapter(getActivity(), artists);
        listView.setAdapter(listingsAdapter);
    }

    @Override
    public void onActivityCreated(Bundle bundle){
        super.onActivityCreated(bundle);
    }
}
