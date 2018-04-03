package finki.ukim.mk.festival.fragments;

import android.Manifest;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.Typeface;
import android.location.Location;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.FusedLocationProviderApi;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

import finki.ukim.mk.festival.MainActivity;
import finki.ukim.mk.festival.R;
import finki.ukim.mk.festival.models.Artist;

public class MapFragment extends com.google.android.gms.maps.MapFragment implements OnMapReadyCallback, GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {
    private Context context;
    private GoogleMap googleMap;
    private GoogleApiClient googleApiClient;
    private LatLng currentLocation;
    private List<Artist> artists;

    public MapFragment(){
        context = null;
        googleMap = null;
        googleApiClient = null;
        currentLocation = null;
        artists = new ArrayList<Artist>();
    }

    public static MapFragment newInstance() {
        MapFragment mapFragment = new MapFragment();
        return mapFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getMapAsync(this);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (googleApiClient == null) { // first time in, setup this fragment
            setRetainInstance(true);

            context = getActivity().getApplication();
            googleApiClient = new GoogleApiClient.Builder(context, this, this)
                    .addApi(LocationServices.API)
                    .build();
            googleApiClient.connect();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        doWhenEverythingIsReady();
    }

    @Override
    public void onPause() {
        super.onPause();
        if (googleMap != null)
            if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                Toast.makeText(context, "DAFAQ?! No PERMISSIONS BITCH!", Toast.LENGTH_SHORT).show();
                return;
            }
        googleMap.setMyLocationEnabled(false);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        this.googleMap = googleMap;

        this.googleMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
            @Override
            public void onInfoWindowClick(Marker marker) {
                FragmentManager fragmentManager = getActivity().getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                String[] parts = marker.getTitle().split("[.]");
                fragmentTransaction.replace(R.id.fragment_container, ArtistDetailsFragment.newInstance(Integer.parseInt(parts[0])), "ArtistDetailsFragment").addToBackStack(null).commit();
            }
        });

        doWhenEverythingIsReady();
    }

    void doWhenEverythingIsReady() {
        /* We have a race condition where the fragment could resume
         * before or after the map is ready. So we put all our logic
         * * for initializing the map into a common method that is
         * * called when the fragment is resumed or resuming and the
         * * map is ready.
         * */
        if(googleMap == null || currentLocation == null)
            return;

        googleMap.setInfoWindowAdapter(new GoogleMap.InfoWindowAdapter() {

            @Override
            public View getInfoWindow(Marker arg0) {
                return null;
            }

            @Override
            public View getInfoContents(Marker marker) {

                LinearLayout info = new LinearLayout(context);
                info.setOrientation(LinearLayout.VERTICAL);

                TextView title = new TextView(context);
                title.setTextColor(Color.BLACK);
                title.setGravity(Gravity.CENTER);
                title.setTypeface(null, Typeface.BOLD);
                title.setText(marker.getTitle());

                TextView snippet = new TextView(context);
                snippet.setTextColor(Color.GRAY);
                snippet.setText(marker.getSnippet());

                info.addView(title);
                info.addView(snippet);

                return info;
            }
        });

        // Add a marker
        MarkerOptions markerOpt = new MarkerOptions()
                .draggable(false)
                .flat(true)
                .position(currentLocation)
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE))
                .title("You are here!!")
                .snippet("*Press on any of the red markers to get more information about the listing\n*Press & Hold on the info window to view details for the artist");
        googleMap.addMarker(markerOpt).showInfoWindow();

        // Move the camera to zoom in on our location
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(currentLocation, 15));
    }

    @Override
    public void onConnected(Bundle bundle) {
        // Figure out where we are (lat, long) as best as we can
        // based on the user's selections for Location Settings
        FusedLocationProviderApi locator = LocationServices.FusedLocationApi;
        if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            Toast.makeText(context, "DAFAQ?!", Toast.LENGTH_SHORT).show();
            return;
        }
        Location myLocation = locator.getLastLocation(googleApiClient);
        // if the services are not available, could get a null location
        if (myLocation == null)
            return;
        double lat = myLocation.getLatitude();
        double lng = myLocation.getLongitude();
        //Log.e("currentLocation - lat", String.valueOf(lat));
        //Log.e("currentLocation - lng", String.valueOf(lng));
        currentLocation = new LatLng(lat, lng);
        artists = MainActivity.artists;

        LatLngBounds.Builder builder = new LatLngBounds.Builder();
        for (Artist a : artists){
            lat = Double.parseDouble(a.getLocation().getLat());
            lng = Double.parseDouble(a.getLocation().getLng());
            LatLng listingLocation = new LatLng(lat, lng);
            Marker marker = googleMap.addMarker(
                    new MarkerOptions()
                            .position(listingLocation)
                            .title(a.getName())
                            .snippet("Playing on " + a.getDate() + " at " + a.getStage())
            );

            builder.include(marker.getPosition());
        }
        LatLngBounds bounds = builder.build();
        int padding = 50; // offset from edges of the map in pixels
        CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngBounds(bounds, padding);
        googleMap.moveCamera(cameraUpdate);
        googleMap.animateCamera(cameraUpdate);

        doWhenEverythingIsReady();
    }

    @Override
    public void onConnectionSuspended(int i) {
        Toast.makeText(context, "Connection suspended", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {
        Toast.makeText(context, "Connection failed", Toast.LENGTH_LONG).show();
    }
}