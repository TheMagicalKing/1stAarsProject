package com.example.testapp.Logic;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.testapp.UI.OevelseActivity;
import com.example.testapp.R;
import java.util.ArrayList;

// Denne fil står for at vise en liste af øvelser til brugerne.

public class OevelseListActivity extends AppCompatActivity {
    ListView oevelseList;
    String[] oevelseName = {"knæbøjninger", "placeholder"};
    int[] oevelseImage = {R.drawable.leg, R.drawable.leg};
    String[] url = {"exorlive.com/video/?culture=da-DK&ex=601", "media.exorlive.com/?id=3313&filetype=mp4&env=production\n"};

    @Override
    protected void onCreate(Bundle savedInstanceState) { //laver viser øvelses activityen
        // samt øvelses listen.
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oevelse_list);
        oevelseList = findViewById(R.id.oevelseList);
<<<<<<< Lav-Dokumentation
        displayList();
    }

    private void displayList() { /* denne funktion tilføjer øvelser til øvelseslisten og tilføjer det til UI'et.*/
        arrayList = new ArrayList<String>();
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrayList){
            @Override
            public View getView(int position, View convertView, ViewGroup parent){
                View view = super.getView(position, convertView,parent);

                TextView textView = (TextView) view.findViewById(android.R.id.text1);
                textView.setTextColor(Color.WHITE);
                textView.setBackground(getResources().getDrawable(R.drawable.bluerounded));

                return view;
            }
        };
        oevelseList.setAdapter(adapter);
        arrayList.add("exorlive.com/video/?culture=da-DK&ex=601");
        arrayList.add("media.exorlive.com/?id=3313&filetype=mp4&env=production");
=======
        CustomAdapter customAdapter = new CustomAdapter();
        oevelseList.setAdapter(customAdapter);
>>>>>>> master
        oevelseList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(OevelseListActivity.this, OevelseActivity.class);
                intent.putExtra("url", url[position]);
                startActivity(intent);
            }
        });
    }

    private class CustomAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return oevelseImage.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = getLayoutInflater().inflate(R.layout.row_data, null);
            TextView name = view.findViewById(R.id.fruits);
            ImageView image = view.findViewById(R.id.images);
            name.setText(oevelseName[position]);
            image.setImageResource(oevelseImage[position]);
            return view;
        }
    }
}
