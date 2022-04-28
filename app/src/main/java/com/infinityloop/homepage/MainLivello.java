package com.infinityloop.homepage;
import android.os.Bundle;
import android.widget.GridView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import controller.GridController;
import model.ModelloInfinito;

public class MainLivello extends AppCompatActivity {
    GridView coursesGV;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        coursesGV = findViewById(R.id.idMainLivello);

        ArrayList<ModelloInfinito> modelloInfinitoArrayList = new ArrayList<ModelloInfinito>();
        modelloInfinitoArrayList.add(new ModelloInfinito("DSA", R.drawable.shape1));
        modelloInfinitoArrayList.add(new ModelloInfinito("JAVA", R.drawable.shape2));
        modelloInfinitoArrayList.add(new ModelloInfinito("C++", R.drawable.shape3));
        modelloInfinitoArrayList.add(new ModelloInfinito("Python", R.drawable.shape4));
        modelloInfinitoArrayList.add(new ModelloInfinito("Javascript", R.drawable.shape5));
        modelloInfinitoArrayList.add(new ModelloInfinito("DSA", R.drawable.shape6));

        GridController adapter = new GridController(this, modelloInfinitoArrayList);
        coursesGV.setAdapter(adapter);
    }
}
