package com.example.arthurfb.mplayer;

import android.support.annotation.NonNull;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Musicas> {
    public WordAdapter(Activity context, ArrayList<Musicas> words) {

        super(context, 0, words);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        Musicas currentMusicas = getItem(position);

        TextView musicaTextView = (TextView) listItemView.findViewById(R.id.musica_nome);

        musicaTextView.setText(currentMusicas.getMnomeMusica());

        TextView artistaTextView = (TextView) listItemView.findViewById(R.id.musica_artista);

        artistaTextView.setText(currentMusicas.getMnomeArtista());


        return listItemView;
    }
}