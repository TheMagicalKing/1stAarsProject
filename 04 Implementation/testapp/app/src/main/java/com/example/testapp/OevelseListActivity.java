package com.example.testapp;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class OevelseListActivity extends AppCompatActivity {
    ArrayList<String> arrayList;
    ListView oevelseList;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oevelse_list);
        oevelseList = findViewById(R.id.oevelseList);
        displayList();
    }

    private void displayList() {
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
        oevelseList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent i = new Intent(OevelseListActivity.this, OevelseActivity.class);
                String s = arrayList.get(position);
                i.putExtra("a", s);
                startActivity(i);
            }
        });
    }
}
