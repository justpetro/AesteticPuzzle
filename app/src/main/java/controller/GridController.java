package controller;

import android.widget.ArrayAdapter;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.infinityloop.homepage.R;

import java.util.ArrayList;

import model.ModelloInfinito;

public class GridController extends ArrayAdapter<ModelloInfinito> {
    public GridController(@NonNull Context context, ArrayList<ModelloInfinito> modelloInfinitoArrayList) {
        super(context, 0, modelloInfinitoArrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listitemView = convertView;
        if (listitemView == null) {
            // Layout Inflater inflates each item to be displayed in GridView.
            listitemView = LayoutInflater.from(getContext()).inflate(R.layout.image_item, parent, false);
        }
        ModelloInfinito modelloInfinito = getItem(position);
        TextView courseTV = listitemView.findViewById(R.id.idTVCourse);
        ImageView courseIV = listitemView.findViewById(R.id.idIVcourse);
        courseTV.setText(modelloInfinito.getInfinito());
        courseIV.setImageResource(modelloInfinito.getImgid());
        return listitemView;
    }
}
