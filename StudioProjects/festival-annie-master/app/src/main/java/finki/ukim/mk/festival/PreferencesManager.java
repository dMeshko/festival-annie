package finki.ukim.mk.festival;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;

import finki.ukim.mk.festival.models.Artist;


public class PreferencesManager {

    private static PreferencesManager instance;
    private Context context;
    private SharedPreferences mPrefs;

    public PreferencesManager(Context context) {
        this.context = context;
        mPrefs = context.getSharedPreferences("MYSHAREDPREF", Activity.MODE_PRIVATE);
    }

    public static PreferencesManager getInstance(Context c) {
        if (instance == null) instance = new PreferencesManager(c);
        return instance;
    }

    public void addFavourite(Artist artist) {
        Gson gson = new Gson();
        String mapString = gson.toJson(artist);
        mPrefs.edit().putString("artist "+artist.getName(), mapString).apply();

    }

    public void removeFavorite(Artist artist) {
        mPrefs.edit().remove("artist "+artist.getName()).apply();
    }


    public boolean hasFavorite(Artist artist) {
        return mPrefs.contains("artist "+artist.getName());
    }
}