package com.example.myapplication;

import android.app.Activity;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class songsAdapter extends ArrayAdapter<songs> {


    public songsAdapter(Activity context, ArrayList<songs> song) {

        super(context, 0, song);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }
        songs song1 = getItem(position);
        TextView nameTextView = (TextView) listItemView.findViewById(R.id.Artist_name);
        nameTextView.setText(song1.getsongName());
        TextView numberTextView = (TextView) listItemView.findViewById(R.id.song_name);
        numberTextView.setText(song1.getartistName());
        ImageView iconView = (ImageView) listItemView.findViewById(R.id.list_item_icon);
        iconView.setImageResource(song1.getImageResourceId());
        return listItemView;
    }
}
