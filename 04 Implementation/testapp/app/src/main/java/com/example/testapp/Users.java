package com.example.testapp;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Users extends AppCompatActivity {
    ListView userList;
    TextView noUsersText;
    ArrayList<String> al = new ArrayList<>();
    int totalUser = 0;
    ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users);

        userList = (ListView)findViewById(R.id.usersList);

    }
}
