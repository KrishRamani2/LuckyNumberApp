package com.mastercoding.luckynumberapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    TextView head;
    EditText Name;
    Button mybtn;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        head = findViewById( R.id.textView);
        Name = findViewById(R.id.editText);

        mybtn = findViewById(R.id.next);
        mybtn.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = Name.getText().toString();
                Intent i = new Intent(
                        getApplicationContext(),
                        SecondActivity.class
                );
                i.putExtra( "name",username );
                startActivity(i);
            }
        } );
    }
}