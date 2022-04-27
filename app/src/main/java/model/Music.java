package model;

import android.media.MediaPlayer;

import com.infinityloop.homepage.MainActivity;
import com.infinityloop.homepage.R;

public class Music {
    private static MediaPlayer song;
    private Music(){}

    //CREA IL MEDIAPLAYER
    public static void createMusic(){
        song = MediaPlayer.create(MainActivity.this, R.raw.homesong);
        song.setLooping(true);
        song.start();
    }
    /*FA PARTIRE LA MUSICA
    public static void startMusic(){
        song.start();
    }*/

    //CONTROLLA SE STA SUONANDO
    public static boolean isPlaying(){
        return song.isPlaying();
    }

    //METTE IN PAUSA O RIPRENDE LA MUSICA
    public static void pauseMusic(){
        if(Music.isPlaying()){
            song.pause();
        }else{
            song.start();
        }
    }





}
