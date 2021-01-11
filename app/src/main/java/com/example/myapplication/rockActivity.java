package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class rockActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        ArrayList<songs> rock = new ArrayList<songs>();
        rock.add(new songs("adel", "Say It to Me Softly.",R.drawable.donut));
        rock.add(new songs("locy", "What's Stopping You?",R.drawable.mm));
        rock.add(new songs("Haydn", "Symphony no. 94 \"Surprise\" ",R.drawable.zz));
        rock.add(new songs("Beethoven", "Symphony No. 9",R.drawable.xx));
        rock.add(new songs("Beethoven", "Symphony No. 3",R.drawable.jellybean));
        rock.add(new songs("Beethoven", "Sonata No. 8  \"Pathétique\"",R.drawable.gingerbread));
        rock.add(new songs("Mozart", "Oboe Concerto in major",R.drawable.lollipop));
        rock.add(new songs("Mozart", "Sonata for Two Pianos",R.drawable.bb));
        rock.add(new songs("Mozart", "Piano Sonata No 16 C major ",R.drawable.donut));
        rock.add(new songs("Haydn", "Piano Concerto No. 11 in D major",R.drawable.mm));
        rock.add(new songs("Haydn", "Symphony no. 94 \"Surprise\" ",R.drawable.zz));
        rock.add(new songs("Haydn", "Symphony No. 45 \"Farewell\"",R.drawable.marshmallow));
        rock.add(new songs("Boccherini", "Minuet in E Major",R.drawable.tt));
        rock.add(new songs("Handel",
                "Water Music, Suite No. 3 in G major, Minuet I, II.",R.drawable.qq));
        rock.add(new songs("Pachelbel",
                "Canon in D Major",R.drawable.icecream));
        rock.add(new songs("Rameau",
                "Suite en la Gavotte et six Doubles",R.drawable.dd));
        rock.add(new songs("Pergolesi",
                "Stabat Mater Dolorosa ",R.drawable.jellybean));
        rock.add(new songs("Purcell",
                "The Cold Song",R.drawable.mm));
        rock.add(new songs("Telemann",
                "Concerto in E major for flute, oboe d'amore, viola d'amore & strings",R.drawable.oo));
        rock.add(new songs("Vinci",
                "In braccio a mille furie (Semiramide riconosciuta)",R.drawable.bb));
        rock.add(new songs("Leo",
                "Mesero pargoletto (Demofoonte)",R.drawable.tt));
        rock.add(new songs("Porpora",
                "Passaggier che sulla sponda (Semiramide riconosciuta)",R.drawable.kitkat));
        rock.add(new songs("Lully",
                "Marche pour la cérémonie des Turcs",R.drawable.honeycomb));
        songsAdapter adapter = new songsAdapter(this, rock);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
        Button goo = (Button) findViewById(R.id.goomain);
        goo.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers View is clicked on.
            @Override
            public void onClick(View view) {
                Intent gooIntent = new Intent(rockActivity.this, catigoryActivity.class);
                startActivity(gooIntent);
            }
        });
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        songs currentOpus = (songs) adapterView.getItemAtPosition(position);
        String opusForPlaying = currentOpus.getsongName();
        String composerForPlaying = currentOpus.getartistName();
        Intent opusIntent = new Intent(this, PlayerActivity.class);
        opusIntent.putExtra("song", opusForPlaying);
        opusIntent.putExtra("artist", composerForPlaying);
        int photoforplaying=currentOpus.getImageResourceId();
        opusIntent.putExtra("photo",photoforplaying);
        startActivity(opusIntent);

    }
}