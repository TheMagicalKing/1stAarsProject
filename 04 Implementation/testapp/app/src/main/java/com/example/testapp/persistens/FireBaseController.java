package com.example.testapp.persistens;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.example.testapp.UI.ForsideActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
/*Denn fil står for at oprettede forbindelse til firebase
og til at logge brugeren ind*/

public class FireBaseController extends AppCompatActivity {
    FirebaseAuth firebaseAuth;
    private AuthResult Task;


    public AuthResult MainFirebaseLogin(final String email, final String password,
                                        final Context activity, final Intent intent){      //Denne funktion henter de intastet bruger oplysniger og sender dem vidre til firebase
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull com.google.android.gms.tasks.Task<AuthResult> task) { /* denne fuktion venter på validering fra firebase.
            og returnere fej vis at password eller brugernavn er forkert.*/
                if (task.isSuccessful()) {
                    System.out.println("I'm in ");
                    System.out.println(intent);
                    Intent i1 = new Intent (activity, ForsideActivity.class);

                    activity.startActivity(i1);

                } else {
                    System.out.println("It failed ");
                    errorToast(activity,task);

                }
            }
        });

            Task = (AuthResult) firebaseAuth.getPendingAuthResult();

        return Task;
    }

    public static void errorToast(Context activity, Task task){ // denne funktion udføre error handling.
        Toast.makeText(activity, "Error !" + task.getException().getMessage(),
                Toast.LENGTH_SHORT).show();
    }

}
