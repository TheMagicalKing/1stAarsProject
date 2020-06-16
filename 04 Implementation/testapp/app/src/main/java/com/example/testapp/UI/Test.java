package com.example.testapp.UI;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.testapp.Logic.CustomListView;
import com.example.testapp.R;

public class Test extends AppCompatActivity {
    ListView oevelseList;
    String[] oevelseName = {"Test1", "Test2"};
    Integer[] imgID = {};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oevelse_list);
        oevelseList = findViewById(R.id.oevelseList);
        CustomListView customListView = new CustomListView(this, oevelseName, imgID);
        oevelseList.setAdapter(customListView);
    }
}
