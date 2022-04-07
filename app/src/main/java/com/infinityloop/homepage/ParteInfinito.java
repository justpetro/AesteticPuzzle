package com.infinityloop.homepage;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

public class ParteInfinito<music> extends AppCompatActivity {
    MediaPlayer music;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_parte_infinito);
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