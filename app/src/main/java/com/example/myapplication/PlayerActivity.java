package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class PlayerActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.player);
        playing();
        Button goomain = (Button) findViewById(R.id.goomain);
        goomain.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers View is clicked on.
            @Override
            public void onClick(View view) {
                Intent goomIntent = new Intent(PlayerActivity.this, MainActivity.class);
                startActivity(goomIntent);
            }
        });

        Button img = (Button) findViewById(R.id.down);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder
                        = new AlertDialog
                        .Builder(PlayerActivity.this);
                builder.setMessage("it will be downloaded as soon as possible ;) \n thank you");
                builder.setTitle("Alert !");
                builder.setCancelable(false);
                builder.setPositiveButton(
                        "Back",
                        new DialogInterface
                                .OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                            }
                        });
                builder.setNegativeButton(
                        "Ok",
                        new DialogInterface
                                .OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog,
                                                int which) {
                                dialog.cancel();
                            }
                        });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }


        });
    }

    public void playing() {
        Intent opusIntent = getIntent();
        TextView TextView1 = findViewById(R.id.player_song);
        String opusForPlaying = opusIntent.getStringExtra("song");
        TextView1.setText(opusForPlaying);
        TextView TextView2 = findViewById(R.id.player_artist);
        String composerForPlaying = opusIntent.getStringExtra("artist");
        TextView2.setText(composerForPlaying);
        ImageView photoforplay = findViewById(R.id.photoo);
        int photoforplaying = opusIntent.getIntExtra("photo", 0);
        photoforplay.setImageResource(photoforplaying);
        if (TextView1.getText().equals("")) {
            String e1 = "Select Artist";
            TextView1.setText(e1);
        }
        if (TextView2.getText().equals("")) {
            String e2 = "Select song";
            TextView2.setText(e2);
        }
        if (photoforplay.getResources() == null) {
            int e3 = R.drawable.bb;
            photoforplay.setImageResource(e3);
        }

    }
}
