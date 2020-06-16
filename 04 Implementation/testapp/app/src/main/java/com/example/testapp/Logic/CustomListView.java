package com.example.testapp.Logic;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.testapp.R;

public class CustomListView extends ArrayAdapter<String> {
    private String[] oevelseName;
    private Integer[] imgId;
    private Activity context;

    public CustomListView(Activity context, String[] oevelseName, Integer[] imgId) {
        super(context, R.layout.listview_layout, oevelseName);
        this.context = context;
        this.oevelseName = oevelseName;
        this.imgId = imgId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        ViewHolder viewHolder = null;
        if (view == null) {
            LayoutInflater layoutInflater = context.getLayoutInflater();
            view = layoutInflater.inflate(R.layout.listview_layout, null, true);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.image.setImageResource(imgId[position]);
        viewHolder.name.setText(oevelseName[position]);
        return view;
    }

    class ViewHolder {
        TextView name;
        ImageView image;

        ViewHolder(View view) {
            name = (TextView) view.findViewById(R.id.oevelseName);
            image = (ImageView) view.findViewById(R.id.oevelseView);
        }
    }
}
