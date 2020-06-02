package com.example.testapp;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.testapp.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class klientChat extends AppCompatActivity {
    private Toolbar mToolbar;
    private ViewPager ViewPager;
    private TableLayout Tablayout;
    private TabsAccessorAdapter TabsAccessorAdapter;
    private FirebaseUser currentUser;
    private FirebaseAuth mAuth;
    private DatabaseReference ref;
    private String currentUserID;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_klient_chat);

        mAuth = FirebaseAuth.getInstance();
        currentUser = mAuth.getCurrentUser();
        currentUserID = mAuth.getCurrentUser().getUid();
        ref = FirebaseDatabase.getInstance().getReference();

        mToolbar = (Toolbar)findViewById(R.id.layout.activity.main);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("chat");

        ViewPager = (ViewPager)findViewById(R.id.main_page_toolbar);
        TabsAccessorAdapter = new TabsAccessorAdapter(getSupportFragmentManager());
        ViewPager.setAdapter(TabsAccessorAdapter);

        Tablayout =(Tablayout)findViewById(R.id.main_tabs);
        Tablayout.setupWithVeiwPager(ViewPager);




        final ImageView backImage = findViewById(R.id.backImage);

        backImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openForside();
            }
        });
    }

    private void  VerifyUserExistance(){
        String currentUserID = mAuth.getCurrentUser().getUid();
        ref.child("users").child(currentUserID).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.child("name").exists()){
                    Toast.makeText(klientChat.this, "Welcome", Toast.LENGTH_SHORT).show());
                }else {

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        super.onCreateOptionsMenu(menu);

        getMenuInflater().inflate(R.menu.options_menu, menu);


        return true;
    }

    private void RequestNewGroupe(){

    }



    private void openForside(){
        Intent intent = new Intent(this, forsideActivity.class);
        startActivity(intent);
    }
}
