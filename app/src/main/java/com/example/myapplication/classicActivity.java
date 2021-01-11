package com.example.myapplication;

import androidx.annotation.RequiresApi;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

public class classicActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        ArrayList<songs> classic = new ArrayList<songs>();
        classic.add(new songs(" Animaniacs", "All the Words in the English Language", R.drawable.vv));
        classic.add(new songs(" Animaniacs", "Around the World", R.drawable.zz));
        classic.add(new songs("Beethoven", "Sonata No. 8  \"Pathétique\"", R.drawable.qq));
        classic.add(new songs("Handel",
                "Water Music, Suite No. 3 in G major, Minuet I, II.", R.drawable.oo));
        classic.add(new songs("Pachelbel",
                "Canon in D Major", R.drawable.bb));
        classic.add(new songs("Rameau",
                "Suite en la Gavotte et six Doubles", R.drawable.lollipop));
        classic.add(new songs("Pergolesi",
                "Stabat Mater Dolorosa ", R.drawable.vv));
        classic.add(new songs("Purcell",
                "The Cold Song", R.drawable.qq));
        classic.add(new songs("Telemann",
                "Concerto in E major for flute, oboe d'amore, viola d'amore & strings", R.drawable.zz));
        classic.add(new songs("Vinci",
                "In braccio a mille furie (Semiramide riconosciuta)", R.drawable.dd));
        classic.add(new songs("Leo",
                "Mesero pargoletto (Demofoonte)", R.drawable.icecream));
        classic.add(new songs("Porpora",
                "Passaggier che sulla sponda (Semiramide riconosciuta)", R.drawable.oo));
        classic.add(new songs("Lully",
                "Marche pour la cérémonie des Turcs", R.drawable.oo));
        classic.add(new songs("Beethoven", "Symphony No. 9", R.drawable.vv));
        classic.add(new songs("Beethoven", "Symphony No. 3", R.drawable.zz));
        classic.add(new songs("Beethoven", "Sonata No. 8  \"Pathétique\"", R.drawable.qq));
        classic.add(new songs("Mozart", "Oboe Concerto in C major", R.drawable.bb));
        classic.add(new songs("Mozart", "Sonata for Two Pianos in D", R.drawable.icecream));
        classic.add(new songs("Mozart", "Piano Sonata No 16 C major ", R.drawable.jellybean));
        classic.add(new songs("Haydn", "Piano Concerto No. 11 in D major", R.drawable.yy));
        classic.add(new songs("Haydn", "Symphony no. 94 \"Surprise\" ", R.drawable.mm));
        classic.add(new songs("Haydn", "Symphony No. 45 \"Farewell\"", R.drawable.dd));
        classic.add(new songs("Boccherini", "Minuet in E Major", R.drawable.eclair));
        songsAdapter adapter = new songsAdapter(this, classic);
        ListView listView = (ListView) findViewById(R.id.list);

        listView.setBackgroundColor(Color.rgb(231, 193, 227));
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
        Button goo = (Button) findViewById(R.id.goomain);
        goo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gooIntent = new Intent(classicActivity.this, catigoryActivity.class);
                startActivity(gooIntent);
            }
        });
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        songs currentsong = (songs) adapterView.getItemAtPosition(position);
        String songForPlaying = currentsong.getsongName();
        String artistForPlaying = currentsong.getartistName();
        Intent opusIntent = new Intent(this, PlayerActivity.class);
        opusIntent.putExtra("song", songForPlaying);
        opusIntent.putExtra("artist", artistForPlaying);
        int photoforplaying = currentsong.getImageResourceId();
        opusIntent.putExtra("photo", photoforplaying);
        startActivity(opusIntent);
    }
}
