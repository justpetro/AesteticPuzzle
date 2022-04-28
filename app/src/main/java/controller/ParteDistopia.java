package controller;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

import com.infinityloop.homepage.R;

public class ParteDistopia extends AppCompatActivity {
    MediaPlayer music;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_parte_distopia);
    }
    public void onClick(View view){
        if(view.getId()==R.id.button){
            music = MediaPlayer.create(ParteDistopia.this, R.raw.comainstrumental);
            music.setLooping(true);
            music.start();
        }
    }
}