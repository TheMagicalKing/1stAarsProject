package com.example.testapp.Logic;

import android.content.Context;
import android.text.TextUtils;
import android.widget.EditText;

import com.example.testapp.persistens.FireBaseController;


public class LogInSystem {

    FireBaseController fireBaseController = new FireBaseController();

    public void logIn(String email, String password, Context activity, EditText userEmail, EditText userPass){
        if (TextUtils.isEmpty(email)) {
            userEmail.setError("Email is Required");
            return;
        }
        if (TextUtils.isEmpty(password)) {
            userPass.setError("Password is Required");
            return;
        }

        if (password.length() < 6) {
            userPass.setError("Password must be >= 6 characters");
            return;
        }

        // authenticating user

        fireBaseController.MainFirebaseLogin(email, password, activity);
    }

}
