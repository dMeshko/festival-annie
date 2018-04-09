package finki.ukim.mk.festival.utilities;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

import finki.ukim.mk.festival.PreferencesManager;
import finki.ukim.mk.festival.R;
import finki.ukim.mk.festival.fragments.ArtistDetailsFragment;
import finki.ukim.mk.festival.models.Artist;

public class ListViewAdapter extends BaseAdapter {
    private List<Artist> artists;
    private Activity ctx;
    private LayoutInflater inflater;

    public ListViewAdapter(Activity ctx, List<Artist> artists){
        this.ctx = ctx;
        inflater = LayoutInflater.from(ctx);
        if (artists != null)
            this.artists = artists;
        else this.artists = new ArrayList<Artist>();
    }

    public void add(Artist item){
        artists.add(item);
        notifyDataSetChanged();
    }

    public void remove(int position){
        artists.remove(position);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return artists.size();
    }

    @Override
    public Object getItem(int i) {
        return artists.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup viewGroup) {
        Holder holder;

        if (convertView == null){
            holder = new Holder();
            convertView = holder.layout = (ConstraintLayout) inflater.inflate(R.layout.list_band_item, null);
            holder.layoutImages = (LinearLayout)holder.layout.findViewById(R.id.images);
            holder.layoutText = (LinearLayout)holder.layout.findViewById(R.id.texts);
            holder.leftImage = (ImageView) holder.layoutImages.findViewById(R.id.leftImage);
            holder.leftText = (TextView) holder.layoutText.findViewById(R.id.leftImageText);
            holder.favoriteBtn = (ImageView) holder.layoutText.findViewById(R.id.favorite_btn);
            convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();
        }



        final Artist artistLeft = (Artist) getItem(position);

        holder.favoriteBtn.setTag(position);


        if(PreferencesManager.getInstance(ctx).hasFavorite(artistLeft)){

            Drawable drawable = ctx.getResources().getDrawable(R.drawable.ic_favorite_white_24dp);
           holder.favoriteBtn.setImageDrawable(drawable);
        }

        Glide
                .with(ctx)
                .load(artistLeft.getImageUrl())
                .centerCrop()
                .placeholder(R.drawable.featured)
                .crossFade()
                .into(holder.leftImage);
        holder.leftText.setText(artistLeft.toString());

        holder.leftImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = ctx.getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, ArtistDetailsFragment.newInstance(position), "ArtistDetailsFragment").addToBackStack(null).commit();
            }
        });

        holder.favoriteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                        int pos = (Integer) view.getTag();
                        Artist art = artists.get(pos);

                        if (PreferencesManager.getInstance(ctx).hasFavorite(art)) {


                            PreferencesManager.getInstance(ctx).removeFavorite(art);

                            Drawable drawable = ctx.getResources().getDrawable(R.drawable.ic_favorite_border_white_24dp);
                            ((ImageView) view).setImageDrawable(drawable);
                        } else {
                            PreferencesManager.getInstance(ctx).addFavourite(art);


                            Drawable drawable = ctx.getResources().getDrawable(R.drawable.ic_favorite_white_24dp);
                            ((ImageView) view).setImageDrawable(drawable);
                        }
                    }
        });

        return convertView;
    }

    static class Holder{
        ConstraintLayout layout;
        LinearLayout layoutImages;
        ImageView leftImage;
        ImageView rightImage, favoriteBtn;
        LinearLayout layoutText;
        TextView leftText;
        TextView rightText;
    }
}
