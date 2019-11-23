package com.example.tmdbapi;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class SignInActivity extends AppCompatActivity {

    EditText et_uname, et_pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        et_uname = findViewById(R.id.et_uname);
        et_pass = findViewById(R.id.et_pass);
    }

    public void signIn(View view){

        Intent intent = new Intent(SignInActivity.this,MainActivity.class);
        startActivity(intent);
    }
}
