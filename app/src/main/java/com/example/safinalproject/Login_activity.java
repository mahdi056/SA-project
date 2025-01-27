package com.example.safinalproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.regex.Pattern;

public class Login_activity extends AppCompatActivity {

    private EditText et_email, et_Give_password;
    private Button btn_Login, btn_register;


    private FirebaseAuth mAuth;

    // Default admin credentials
    private static final String ADMIN_EMAIL = "mahdi@gmail.com";
    private static final String ADMIN_PASSWORD = "Mahdi0018";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Initialize UI elements
        et_email = findViewById(R.id.et_user_email);
        et_Give_password = findViewById(R.id.et_user_password);
        btn_Login = findViewById(R.id.btn_Login);
        btn_register = findViewById(R.id.btn_register);
//

        // Initialize FirebaseAuth
        mAuth = FirebaseAuth.getInstance();




        // Set login button click listener
        btn_Login.setOnClickListener(v -> validateAndDoLogin());

        // Set click listener for the register button
        btn_register.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), Register_activity.class);
            startActivity(intent);
            finish();
        });
    }

    private void validateAndDoLogin() {
        String email = et_email.getText().toString().trim();
        String password = et_Give_password.getText().toString().trim();

        // Regex patterns
        Pattern emailPattern = Pattern.compile("^[a-zA-Z0-9._-]+@[a-z]+\\.[a-z]{2,6}$");
        Pattern passwordPattern = Pattern.compile("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{6,}$");

        // Empty field validation
        if (email.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Both fields must be filled out!", Toast.LENGTH_SHORT).show();
            return;
        }

        // Email format validation
        if (!emailPattern.matcher(email).matches()) {
            Toast.makeText(this, "Incorrect email address!", Toast.LENGTH_SHORT).show();
            et_email.requestFocus();
            return;
        }

        // Password format validation
        if (!passwordPattern.matcher(password).matches()) {
            Toast.makeText(this, "Password must be at least 6 characters with a number and a letter.", Toast.LENGTH_SHORT).show();
            et_Give_password.requestFocus();
            return;
        }

        // Show ProgressBar and start login


        // Check for admin credentials
        if (email.equals(ADMIN_EMAIL) && password.equals(ADMIN_PASSWORD)) {
           // Hide ProgressBar
            Intent intent = new Intent(getApplicationContext(), Adminhome.class);
            startActivity(intent);
            finish();
        } else {
            mAuth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, task -> {

                        if (task.isSuccessful()) {
                            FirebaseUser user = mAuth.getCurrentUser();
                            if (user != null && user.isEmailVerified()) {
                                Intent intent = new Intent(getApplicationContext(), Welcome.class);
                                startActivity(intent);
                                finish();
                            } else {
                                Toast.makeText(Login_activity.this, "Verify email first", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(Login_activity.this, "Login failed! Please check your credentials.", Toast.LENGTH_SHORT).show();
                        }
                    });
        }
    }
}
