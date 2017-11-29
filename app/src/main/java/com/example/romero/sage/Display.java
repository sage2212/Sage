package com.example.romero.sage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.TextView;

public class Display extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        String username = getIntent().getStringExtra("Username");

        TextView tv = (TextView)findViewById(R.id.tvusername);
        tv.setText(username);
    }
}
