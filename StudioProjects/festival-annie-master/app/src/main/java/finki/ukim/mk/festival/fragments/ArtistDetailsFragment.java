package finki.ukim.mk.festival.fragments;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import finki.ukim.mk.festival.MainActivity;
import finki.ukim.mk.festival.R;
import finki.ukim.mk.festival.models.Artist;

public class ArtistDetailsFragment extends Fragment {
    private int active;
    private Artist artist;

    public ArtistDetailsFragment() {
        active = -1;
    }

    public static ArtistDetailsFragment newInstance(int active) {
        ArtistDetailsFragment fragment = new ArtistDetailsFragment();
        Bundle args = new Bundle();
        args.putInt("active", active);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            active = getArguments().getInt("active");
        }
        artist = MainActivity.artists.get(active);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.artist_details_fragment, container, false);

        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
    }

    @Override
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        display();
    }

    @Override
    public void onViewStateRestored(Bundle bundle) {
        super.onViewStateRestored(bundle);
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    private void display() {
        ImageView artistImage = getActivity().findViewById(R.id.f_ad_artist_band_image);
        Glide
                .with(getActivity())
                .load(artist.getImageUrl())
                .centerCrop()
                .placeholder(R.drawable.featured)
                .crossFade()
                .into(artistImage);

        TextView artistName = getActivity().findViewById(R.id.f_ad_artist_band_name);
        artistName.setText(artist.toString());

        TextView artistBio = getActivity().findViewById(R.id.f_ad_artist_band_bio);
        artistBio.setText(artist.getBiography());
//        TextView textViewTitle = (TextView) getActivity().findViewById(R.id.ld_title);
//        textViewTitle.setText(listing.getTitle());
//        TextView textViewContent = (TextView) getActivity().findViewById(R.id.ld_content);
//        textViewContent.setText(Html.fromHtml(listing.getContent()));
//        TextView textViewAuthor = (TextView) getActivity().findViewById(R.id.ld_author);
//        textViewAuthor.setText(listing.getUser().getUsername());
//        TextView textViewTimestamp = (TextView) getActivity().findViewById(R.id.ld_timestamp);
//        textViewTimestamp.setText(listing.getCreatedOn());
//        //Slider
//        SliderLayout slider = (SliderLayout) getActivity().findViewById(R.id.vl_listings_slider_1);
//        slider.setPresetTransformer(SliderLayout.Transformer.Stack);
//        slider.setPresetIndicator(SliderLayout.PresetIndicators.Right_Bottom);
//
//        for(String img : listing.getImageURLs()){
//            TextSliderView textSliderView = new TextSliderView(getActivity());
//            try{
//
//                textSliderView
//                        .image(String.valueOf(new URI(Constants.SERVER_IP_ADDRESS + img)))
//                        .setScaleType(BaseSliderView.ScaleType.Fit);
//
//            }catch(URISyntaxException e){
//                e.printStackTrace();
//            }
//            slider.addSlider(textSliderView);
//        }
    }
}
