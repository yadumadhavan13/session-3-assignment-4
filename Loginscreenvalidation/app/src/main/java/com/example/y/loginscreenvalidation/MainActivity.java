package com.example.y.loginscreenvalidation;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView warnintext;
    EditText emailtext;
    EditText passwordtext;
    Button loginbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        warnintext = (TextView) findViewById(R.id.warningtext);
        emailtext = (EditText) findViewById(R.id.emailtext);
        passwordtext = (EditText) findViewById(R.id.passwordtext);
        loginbutton = (Button) findViewById(R.id.loginbutton);


        loginbutton.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        //validation for Empty email field
        if (emailtext.getText().toString().length()==0){
            Toast.makeText(this, "Email field cannot be Empty", Toast.LENGTH_SHORT).show();
            Log.e("MainActivity","Empty email option is invoked");
            emailtext.setError("Email field cannot be Empty");
            warnintext.setTextColor(Color.RED);
            warnintext.setVisibility(View.VISIBLE);
            return;
        }
        //validation weather entered email address pattern is valid or not
        else if(! Patterns.EMAIL_ADDRESS.matcher(emailtext.getText().toString()).matches()){
            Toast.makeText(this, "Invalid Email", Toast.LENGTH_SHORT).show();
            Log.e("MainActivity","invalid email option invoked");
            emailtext.setError("Invalid Email");
            warnintext.setTextColor(Color.RED);
            warnintext.setText("Invalid Email");
            warnintext.setVisibility(View.VISIBLE);
            return;

        }
        //validation for Empty Password field
        else if (passwordtext.getText().toString().length()==0){
            Toast.makeText(this, "Password field cannot be Empty", Toast.LENGTH_SHORT).show();
            Log.e("MainActivity","Empty password option is invoked");
            passwordtext.setError("Password field cannot be Empty");
            warnintext.setTextColor(Color.RED);
            warnintext.setVisibility(View.VISIBLE);
            return;

        }
        else {
            //validation for succesfull login
            Toast.makeText(this, "Validation succesfull", Toast.LENGTH_SHORT).show();
            Log.e("MainActivity","validation succesfull option is invoked");
            warnintext.setText("Log in Successfull");
            warnintext.setTextColor(Color.GREEN);
            warnintext.setVisibility(View.VISIBLE);
            return;
        }




    }


}
