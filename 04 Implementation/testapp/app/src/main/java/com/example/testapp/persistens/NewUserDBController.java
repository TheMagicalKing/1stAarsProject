package com.example.testapp.persistens;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.example.testapp.UI.NewUserActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

// Denne fil og den fuktioner ud føre den samme opgave som den anden kontroller blot med user creation isten for
public class NewUserDBController extends AppCompatActivity {
    FirebaseAuth firebaseAuth;

    public AuthResult newUserFirebaseAdd(final String email, final String password, final Context context, final Intent intent){
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull com.google.android.gms.tasks.Task<AuthResult> task) {
                if (task.isSuccessful()){
                    System.out.println("Bruger Oprettede");
                    System.out.println(intent);
                    Intent intent1 = new Intent(context, NewUserActivity.class);

                    context.startActivity(intent1);
                } else {
                    System.out.println("Error! Bruger ikke oprettede");
                    errorToast(context, task);
                }
            }
        });

        AuthResult task = (AuthResult) firebaseAuth.getPendingAuthResult();

        return task;
    }

    public static void errorToast (Context context, Task task){
        Toast.makeText(context, "Error!"+task.getException().getMessage(),
                Toast.LENGTH_SHORT).show();
    }

}
