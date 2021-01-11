package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

public class hibhobActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_list);


        ArrayList<songs> hibhop = new ArrayList<songs>();
        hibhop.add(new songs("Bob Dylan", "A Hard Rain's a-Gonna Fall", R.drawable.honeycomb));
        hibhop.add(new songs(" Billy Bragg", "A Little Something Refreshing", R.drawable.mm));
        hibhop.add(new songs(" Billy Bragg", "A13 Trunk Road to the Sea", R.drawable.kitkat));
        hibhop.add(new songs("Beethoven", "Symphony No. 9", R.drawable.honeycomb));
        hibhop.add(new songs("Beethoven", "Symphony No. 3", R.drawable.mm));
        hibhop.add(new songs("Beethoven", "Sonata No. 8  \"Pathétique\"", R.drawable.kitkat));
        hibhop.add(new songs("Mozart", "Oboe Concerto in C major", R.drawable.froyo));
        hibhop.add(new songs("Mozart", "Sonata for Two Pianos in D", R.drawable.oo));
        hibhop.add(new songs("Mozart", "Piano Sonata No 16 C major ", R.drawable.tt));
        hibhop.add(new songs("Haydn", "Piano Concerto No. 11 in D major", R.drawable.bb));
        hibhop.add(new songs("Haydn", "Symphony no. 94 \"Surprise\" ", R.drawable.jellybean));
        hibhop.add(new songs("Haydn", "Symphony No. 45 \"Farewell\"", R.drawable.jellybean));
        hibhop.add(new songs("Boccherini", "Minuet in E Major", R.drawable.icecream));
        hibhop.add(new songs("Handel",
                "Water Music, Suite No. 3 in G major, Minuet I, II.", R.drawable.dd));
        hibhop.add(new songs("Pachelbel",
                "Canon in D Major", R.drawable.mm));
        hibhop.add(new songs("Rameau",
                "Suite en la Gavotte et six Doubles", R.drawable.zz));
        hibhop.add(new songs("Pergolesi",
                "Stabat Mater Dolorosa ", R.drawable.qq));
        hibhop.add(new songs("Purcell",
                "The Cold Song", R.drawable.lollipop));
        hibhop.add(new songs("Telemann",
                "Concerto in E major for flute, oboe d'amore, viola d'amore & strings", R.drawable.vv));
        hibhop.add(new songs("Vinci",
                "In braccio a mille furie (Semiramide riconosciuta)", R.drawable.oo));
        hibhop.add(new songs("Leo",
                "Mesero pargoletto (Demofoonte)", R.drawable.bb));
        hibhop.add(new songs("Porpora",
                "Passaggier che sulla sponda (Semiramide riconosciuta)", R.drawable.oo));
        hibhop.add(new songs("Lully",
                "Marche pour la cérémonie des Turcs", R.drawable.oo));
        songsAdapter adapter = new songsAdapter(this, hibhop);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setBackgroundColor(Color.rgb(252, 167, 83));
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
        Button goo = (Button) findViewById(R.id.goomain);
        goo.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers View is clicked on.
            @Override
            public void onClick(View view) {
                Intent gooIntent = new Intent(hibhobActivity.this, catigoryActivity.class);
                startActivity(gooIntent);
            }
        });

    }

    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        // Get the selected opus.
        songs currentOpus = (songs) adapterView.getItemAtPosition(position);

        String opusForPlaying = currentOpus.getsongName();
        String composerForPlaying = currentOpus.getartistName();
        Intent opusIntent = new Intent(this, PlayerActivity.class);
        opusIntent.putExtra("song", opusForPlaying);
        opusIntent.putExtra("artist", composerForPlaying);
        int photoforplaying = currentOpus.getImageResourceId();
        opusIntent.putExtra("photo", photoforplaying);
        startActivity(opusIntent);
    }

}
