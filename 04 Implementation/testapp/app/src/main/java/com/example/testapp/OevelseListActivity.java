package com.example.testapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.net.URL;
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
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrayList);
        oevelseList.setAdapter(adapter);
        arrayList.add("exorlive.com/video/?culture=da-DK&ex=601");
        arrayList.add("media.exorlive.com/?id=3313&filetype=mp4&env=production");
        oevelseList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent i = new Intent(OevelseListActivity.this, oevelseActivity.class);
                String s = arrayList.get(position);
                i.putExtra("a", s);
                startActivity(i);
            }
        });
    }
}
