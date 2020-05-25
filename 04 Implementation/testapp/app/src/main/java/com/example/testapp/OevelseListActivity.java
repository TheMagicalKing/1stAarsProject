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
    private String[] items;
    private ListView oevelseList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oevelse_list);
        oevelseList = findViewById(R.id.oevelseList);
        displayList();
    }

    private void displayList() {
        final ArrayList<String> oevelse = new ArrayList<>();
        oevelse.add("http://exorlive.com/video/?culture=da-DK&ex=601");
        items = new String[oevelse.size()];
        for (int i = 0; i < oevelse.size(); i++) {
            items[i] = oevelse.get(i);
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(OevelseListActivity.this, android.R.layout.simple_list_item_1, items);
        oevelseList.setAdapter(arrayAdapter);
        oevelseList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String name = oevelseList.getItemAtPosition(position).toString();
                Intent intent = new Intent(OevelseListActivity.this, oevelseActivity.class);
                intent.putExtra("oevelse", oevelse);
                intent.putExtra("name", name);
                intent.putExtra("position", position);
                startActivity(intent);
            }
        });
    }
}
