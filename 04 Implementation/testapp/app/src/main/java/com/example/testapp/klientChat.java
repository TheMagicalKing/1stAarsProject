package com.example.testapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DownloadManager;
import android.content.Intent;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.testapp.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;


public class klientChat extends AppCompatActivity {
    private static final int RC_SIGN_IN = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_klient_chat);

            displayChatMessages();

        final ImageView backImage = findViewById(R.id.backImage);

        backImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openForside();
            }
            FloatingActionButton fab = findViewById(R.id.fab);
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    EditText input = findViewById(R.id.input);

                    FirebaseDatabase.getInstance().getReference().push()
                            .setValue(new ChatMessages(input.getText().toString(), FirebaseAuth.getInstance()
                                    .getCurrentUser().getDisplayName()));

                    input.setText("");
                }
            });

        });
    }

    public void displayChatMessages(){
        ListView listOfMessages = findViewById(R.id.list_of_messages);
        DownloadManager.Query query = FirebaseDatabase.getInstance().getReference().child("chats");

        FirebaseListOptions<ChatMessages> options = new FirebaseListOptions.Builder<ChatMessages>()
                .setQuery(query, ChatMessages.class).setLayout(android.R.layout.activity_list_item).build();

        FirebaseListAdapter<ChatMessages> adapter = new FirebaseListAdapter<ChatMessages>(options) {
            @Override
            protected void populateView( View v,ChatMessages model, int position) {
                TextView messageText = v.findViewById(R.id.message_text);
                TextView messageUser = v.findViewById(R.id.message_user);
                TextView messageTime = v.findViewById(R.id.message_time);


                messageText.setText(model.getMessageText());
                messageUser.setText(model.getMessageUser());

                new DateFormat();
                long date = 0;
                messageTime.setText(DateFormat.format("dd/MM/yyyy hh:mm:ss", date).toString());
            }
        };
        listOfMessages.setAdapter(adapter);
    }










    private void openForside(){
        Intent intent = new Intent(this, forsideActivity.class);
        startActivity(intent);
    }
}
