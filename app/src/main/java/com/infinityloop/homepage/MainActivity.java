package com.infinityloop.homepage;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import controller.ParteDistopia;
import controller.ParteGround;
import controller.ParteInfinito;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    MediaPlayer music;
    int count = 0; //Serve per far funzionare il metodo mute

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
        WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        music = MediaPlayer.create(MainActivity.this, R.raw.homesong); //usare musica in backround
        music.setLooping(true);//comando per tenere il brano in loop
        music.start();


        findViewById(R.id.btninfinito).setOnClickListener(this);
        findViewById(R.id.btndistopia).setOnClickListener(this);
        findViewById(R.id.btnground).setOnClickListener(this);

    }
    public void displayToast(View view){ //messaggio toast indicante stato musica
        if (music.isPlaying()) {
            Toast.makeText(MainActivity.this, "Musica OFF", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(MainActivity.this, "Musica ON", Toast.LENGTH_SHORT).show();
        }
    }

    public void mute(View v) { //funzionamento del comando mute
        if(count == 0){
            music.pause();
            count=1;
        }else if(count == 1){
            music.start();
            count=0;
        }
    }


    public void onClick(View view){ // metodo per passare da un'attività all'altra

        if (view.getId() == R.id.btninfinito){
            startActivity(new Intent(this, ParteInfinito.class));
            overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
        }
        if (view.getId() == R.id.btndistopia){
            startActivity(new Intent(this, ParteDistopia.class));
            overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
        }
        if (view.getId() == R.id.btnground){
            startActivity(new Intent(this, ParteGround.class));
            overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
        }


    }
    public void onDestroy(){ //metodo per uccidere il processo chiusa l'app
        super.onDestroy();
        int id= android.os.Process.myPid();
        android.os.Process.killProcess(id);
    }


}
