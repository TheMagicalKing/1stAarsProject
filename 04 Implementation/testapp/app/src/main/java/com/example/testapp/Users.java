package com.example.testapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;

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
        noUsersText = (TextView)findViewById(R.id.noUsersText);

        pd = new ProgressDialog(Users.this);
        pd.setMessage("loading ..");
        pd.show();

        String url = "https://console.firebase.google.com/project/chat-test-6a7f9/authentication/users";

        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                doOnSuccess(s);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println("" + volleyError);
            }
        });
    }


    RequestQueue requestQueue = Volley.newRequestQueue(Users.this);
        requestQueue.add(request);

        userList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                UserDetails.chatWith = al.get(position);
                startActivity(new Intent(Users.this, klientChat.class));
            }
        });
    }

    public void  doOnSuccess(String s){
        try {
            JSONObject object = new JSONObject(s);
            Iterator i = object.keys();
            String key = "";

            while (i.hasNext()){
                key = i.next().toString();

                if (!key.equals(UserDetails.username)){
                    al.add(key);
                }

                totalUser++;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        if (totalUser <=1){
            noUsersText.setVisibility(View.VISIBLE);
            userList.setVisibility(View.GONE);
        }else{
            noUsersText.setVisibility(View.GONE);
            userList.setVisibility(View.VISIBLE);
            userList.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1));
        }

        pd.dismiss();
    }
}
