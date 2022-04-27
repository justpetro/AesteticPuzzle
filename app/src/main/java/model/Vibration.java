package model;

import android.annotation.SuppressLint;
import android.content.Context;

public class Vibration {
    private Vibration(){}

    @SuppressLint("ServiceCast")
    public static void StartVibr(Context context){
        Vibration v;
        v = (Vibration) context.getSystemService(Context.VIBRATOR_SERVICE);

        /*assert v != null;
        v.vibrate(250);

        METODO IN TEORIA PER SETTARE LA VIBRAZIONE
        */


    }
}
