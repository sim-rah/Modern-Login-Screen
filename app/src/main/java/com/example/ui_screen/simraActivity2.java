package com.example.a_suidesignandbuttonclickevent;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ui_screen.R;

public class simraActivity2 extends AppCompatActivity {

    Button infoBtn, backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simra2);

        infoBtn = findViewById(R.id.infoBtn);
        backBtn = findViewById(R.id.backBtn);

        infoBtn.setOnClickListener(v ->
                Toast.makeText(this,
                        "Simra Jameel\nRoll No:F23-0566",
                        Toast.LENGTH_LONG).show()
        );

        backBtn.setOnClickListener(v -> finish());
        startActivity(new Intent(this, simraActivity2.class));
    }
}