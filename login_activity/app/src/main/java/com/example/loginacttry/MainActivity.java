package com.example.loginacttry;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText Mobile;
    private EditText Password;
    private TextView Info;
    private Button Login;
    private int counter = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Mobile = (EditText) findViewById(R.id.etmobile);
        Password = (EditText) findViewById(R.id.etpassword);
        Info = (TextView) findViewById(R.id.tvattempts);
        Login = (Button) findViewById(R.id.btlogin);
        Info.setText("Attempts Left: 5");

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate(Mobile.getText().toString(), Password.getText().toString());
            }
        });

    }


    private void validate(String userName,String userPassword) {

        if ((userName.equals("9098524350")) || (userPassword.equals("1234"))) {
            Intent intent = new Intent(MainActivity.this, HomeActivity.class);
            startActivity(intent);
        }
        else {
            counter--;
            Info.setText("Attempts Left:" + String.valueOf(counter));
            if (counter == 0) {

                Login.setEnabled(false);

            }
        }

    }

}







