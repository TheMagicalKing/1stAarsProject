package com.example.testapp.persistens;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.testapp.forsideActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class FireBaseController extends AppCompatActivity {
    FirebaseAuth firebaseAuth;
    private AuthResult Task;


    public void MainFirebase(){
//        FirebaseAuth.getInstance();
    }
    public AuthResult MainFirebaseLogin(final String email, final String password, final Context activity, final Intent intent){
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull com.google.android.gms.tasks.Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    System.out.println("I'm in bitch");
                    System.out.println(intent);
                    Intent i1 = new Intent (activity, forsideActivity.class);

                    activity.startActivity(i1);

                } else {
                    System.out.println("It failed bitch");
                    errorToast(activity,task);

                }
            }
        });

            Task = (AuthResult) firebaseAuth.getPendingAuthResult();

        return Task;
    }

    public static void errorToast(Context activity, Task task){
        Toast.makeText(activity, "Error !" + task.getException().getMessage(),
                Toast.LENGTH_SHORT).show();
    }

}
