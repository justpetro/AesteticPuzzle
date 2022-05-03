package com.infinityloop.homepage;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

import com.infinityloop.homepage.R;

import model.LivelliInfinito;

public class ParteInfinito<music> extends AppCompatActivity {
    MediaPlayer music;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_parte_infinito);
    }

    public void onClick(View view){  //sto codice qua fa crashare l'app
        if (view.getId() == R.id.button){
            startActivity(new Intent(this, LivelliInfinito.class));
            overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
        }
    }



    /* public void onClick(View view){ WORK IN PROGRESS
        if(view.getId()==R.id.button){
            music = MediaPlayer.create(ParteInfinito.this, R.raw.comainstrumental);
            if() {//condizione affinché il main brano sia in esecuzione
                music.setLooping(true);
                music.start();
            }
        }
    } */
}