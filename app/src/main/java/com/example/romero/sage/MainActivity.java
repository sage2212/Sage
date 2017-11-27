package com.example.romero.sage;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper helper = new DatabaseHelper(this);
    Context mcontext,mcontext1;

    Button btnlogin;
    Button btnsign;
    EditText username,pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mcontext= this;
        bindViews();


        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = username.getText().toString();
                String pass1 = pass.getText().toString();

                String password = helper.searchPass(str);
                if(pass1.equals(password)){
                    Intent i = new Intent(mcontext, Display.class);
                    i.putExtra("Username",str);
                    startActivity(i);
                }
                else
                {
                    Toast temp = Toast.makeText(mcontext, "user name andPassword don't match!", Toast.LENGTH_SHORT);
                    temp.show();
                }

            }

        });
        btnsign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vv) {
                Intent ii = new Intent(MainActivity.this, SignUp.class);
                startActivity(ii);
            }
        });


    }

    private void bindViews(){
        btnlogin = (Button)findViewById(R.id.btnlogin);
         username = (EditText)findViewById(R.id.txtusername);
         btnsign = (Button)findViewById(R.id.btnsign);
         pass = (EditText)findViewById(R.id.txtpass);

    }

}
