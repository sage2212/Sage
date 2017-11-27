package com.example.romero.sage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SignUp extends AppCompatActivity {


    DatabaseHelper helper = new DatabaseHelper(this);

    Button btnsign;
    EditText nombre,email,username,pass1,pass2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        bindViews();

        btnsign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user1 = nombre.getText().toString();
                String emailus = email.getText().toString();
                String user2 = username.getText().toString();
                String passw1 = pass1.getText().toString();
                String passw2 = pass2.getText().toString();

                if(!passw1.equals(passw2)){
                Toast passs = Toast.makeText(SignUp.this, "Password don't match!", Toast.LENGTH_SHORT);
                passs.show();
                }
                else
                {
                    Contact c = new Contact();
                    c.setName(user1);
                    c.setEmail(emailus);
                    c.setUsername(user2);
                    c.setPass(passw1);

                    helper.insertContact(c);
                }
            }

        });
    }




    private void bindViews(){
        nombre = (EditText)findViewById(R.id.txtname);
        email = (EditText)findViewById(R.id.txtemail);
        username = (EditText)findViewById(R.id.txtusername);
        pass1 = (EditText)findViewById(R.id.txtpass);
        pass2 = (EditText)findViewById(R.id.txtcpass);
        btnsign = (Button)findViewById(R.id.btnup);

    }
}
