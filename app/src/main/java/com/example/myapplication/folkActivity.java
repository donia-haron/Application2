package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class folkActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        ArrayList<songs> folk = new ArrayList<songs>();
        folk.add(new songs("Brahms", "Symphony No.4 in E minor.", R.drawable.dd));
        folk.add(new songs("Liszt", "Transcendental Étude no.04 \"Mazeppa\"", R.drawable.eclair));
        folk.add(new songs("Liszt", "Liebestraum No. 3, Notturno", R.drawable.mm));
        folk.add(new songs("Chopin", "Nocturne op.9 No.2", R.drawable.bb));
        folk.add(new songs("Chopin", "Etude in E minor, Op. 25, No. 5", R.drawable.yy));
        folk.add(new songs("Schubert", "Piano Sonata No.13 in A-dur", R.drawable.jellybean));
        folk.add(new songs("Schubert", "Impromptu Op.90 No.4 in A-flat major", R.drawable.icecream));
        folk.add(new songs("Viardot", "\"Haí Lulí\"", R.drawable.dd));
        folk.add(new songs("Schumann", "Concerto for Violoncello and Orchestra A minor", R.drawable.qq));
        folk.add(new songs("Delibes", "Lakmé - Flower Duet", R.drawable.vv));
        folk.add(new songs("Beethoven", "Symphony No. 9", R.drawable.zz));
        folk.add(new songs("Beethoven", "Symphony No. 3", R.drawable.bb));
        folk.add(new songs("Beethoven", "Sonata No. 8  \"Pathétique\"", R.drawable.oo));
        folk.add(new songs("Mozart", "Oboe Concerto in C major", R.drawable.lollipop));
        folk.add(new songs("Brahms", "In My Arms Tonight.\n", R.drawable.dd));
        folk.add(new songs("Liszt", "Racing to Somewhere.", R.drawable.eclair));
        folk.add(new songs("Liszt", "Liebestraum No. 3, Notturno", R.drawable.mm));
        folk.add(new songs("Mozart", "Sonata for Two Pianos in D", R.drawable.tt));
        folk.add(new songs("Mozart", "Piano Sonata No 16 C major ", R.drawable.kitkat));
        folk.add(new songs("Haydn", "Piano Concerto No. 11 in D major", R.drawable.froyo));
        folk.add(new songs("Haydn", "Symphony no. 94 \"Surprise\" ", R.drawable.honeycomb));
        folk.add(new songs("Haydn", "Symphony No. 45 \"Farewell\"", R.drawable.lollipop));
        folk.add(new songs("Boccherini", "Minuet in E Major", R.drawable.gingerbread));
        songsAdapter adapter = new songsAdapter(this, folk);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setBackgroundColor(Color.GRAY);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(this);
        Button goo = (Button) findViewById(R.id.goomain);
        goo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gooIntent = new Intent(folkActivity.this, catigoryActivity.class);
                startActivity(gooIntent);
            }
        });
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
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

