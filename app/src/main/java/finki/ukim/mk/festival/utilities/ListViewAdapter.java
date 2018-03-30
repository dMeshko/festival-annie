package finki.ukim.mk.festival.utilities;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.net.Uri;
import android.support.constraint.ConstraintLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import finki.ukim.mk.festival.R;
import finki.ukim.mk.festival.fragments.ArtistDetailsFragment;
import finki.ukim.mk.festival.models.Artist;

/**
 * Created by Darrk on 3/29/2018.
 */

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
            convertView.setTag(holder);
        }

        holder = (Holder) convertView.getTag();

        Artist artistLeft = (Artist) getItem(position);

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

        return convertView;
    }

    static class Holder{
        ConstraintLayout layout;
        LinearLayout layoutImages;
        ImageView leftImage;
        ImageView rightImage;
        LinearLayout layoutText;
        TextView leftText;
        TextView rightText;
    }
}
