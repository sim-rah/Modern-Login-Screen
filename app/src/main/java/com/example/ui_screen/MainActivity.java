package com.example.a_suidesignandbuttonclickevent;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ui_screen.R;

public class MainActivity extends AppCompatActivity {

    EditText usernameEditText, passwordEditText;
    Button signInButton;

    String correctUsername = "simra";
    String correctPassword = "1234";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usernameEditText = findViewById(R.id.usernameEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        signInButton = findViewById(R.id.signInButton);

        // Initially button disabled (grey)
        signInButton.setEnabled(false);

        // Text change listener
        TextWatcher watcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void afterTextChanged(Editable s) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                checkInputs();
            }
        };

        usernameEditText.addTextChangedListener(watcher);
        passwordEditText.addTextChangedListener(watcher);

        // Button click
        signInButton.setOnClickListener(v -> {
            String user = usernameEditText.getText().toString().trim();
            String pass = passwordEditText.getText().toString().trim();

            if(user.equals(correctUsername) && pass.equals(correctPassword)) {
                Toast.makeText(MainActivity.this, "Login Successful 🎉", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(MainActivity.this, MainActivity.class);
                startActivity(intent);
            } else {
                Toast.makeText(MainActivity.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
            }
        });
    }

    // Check inputs for enabling button
    private void checkInputs() {
        String user = usernameEditText.getText().toString().trim();
        String pass = passwordEditText.getText().toString().trim();

        if(user.equals(correctUsername) && pass.equals(correctPassword)) {
            signInButton.setEnabled(true);   // turns GREEN automatically
        } else {
            signInButton.setEnabled(false);  // stays GREY
        }
    }
}