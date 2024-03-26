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

import java.util.Random;

public class SecondActivity extends AppCompatActivity {
    TextView headline,luck;
    Button mybtns;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);
        headline = findViewById(R.id.textView1);
        luck = findViewById(R.id.number);
        mybtns = findViewById(R.id.share);

        Intent i = getIntent();
        String username = i.getStringExtra( "name" );
        int luckynumber = randomnum();
        luck.setText(""+ luckynumber );
        mybtns.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shareData(username,luckynumber);
            }
        } );
    }
    public int randomnum(){
        Random random = new Random();
        int high = 999;
        int low =0;
        int randomnumber = random.nextInt(high);
        return randomnumber;
    }
    public void shareData(String username , int randomnum){
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType( "text/plain" );
        i.putExtra( Intent.EXTRA_SUBJECT, username + "got lucky today!!");
        i.putExtra( Intent.EXTRA_SUBJECT,"My lucky number is "+ randomnum );
        startActivity( Intent.createChooser( i,"Choose A Platform" ) );
    }
}