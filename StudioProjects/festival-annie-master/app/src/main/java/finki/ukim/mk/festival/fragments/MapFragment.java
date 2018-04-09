package finki.ukim.mk.festival.fragments;


import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import finki.ukim.mk.festival.R;

public class MapFragment extends FragmentActivity {



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map_fragment_layout);

        ImageView mainStagePin = findViewById(R.id.main_stage_pin);
        mainStagePin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri gmmIntentUri = Uri.parse("google.navigation:q=" + getString(R.string.mainStageLan) + "," + getString(R.string.mainStageLon) + "&mode=w");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");

                startActivity(mapIntent);
            }
        });
    }
}