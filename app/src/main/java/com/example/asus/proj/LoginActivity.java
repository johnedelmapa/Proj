package com.example.asus.proj;


import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener  {

    EditText etName, etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        bind();
    }

    public void bind(){
        etName = (EditText) findViewById(R.id.etName);
        etPassword = (EditText) findViewById(R.id.etPassword);
        findViewById(R.id.btnMatch).setOnClickListener(this);
        findViewById(R.id.btnExit).setOnClickListener(this);
    }

    public void login(){

        String user = etName.getText().toString();
        String password = etPassword.getText().toString();
        SharedPreferences preferences = getSharedPreferences("MYPREFS", MODE_PRIVATE);

        if(user.isEmpty()) {
            etName.setError("Username is required");
            etName.requestFocus();
            return;
        }

        if(password.isEmpty()) {
            etPassword.setError("Password is required");
            etPassword.requestFocus();
            return;
        }

        if(password.length()<6) {
            etPassword.setError("Password must be 6 characters");
            etPassword.requestFocus();
            return;
        }

        //String savedPassword = preferences.getString(password, "");
        //String savedUserName = preferences.getString(user, "");

        String userDetails = preferences.getString(user + password + "data", "No information on that user.");
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("display", userDetails);
        editor.commit();

        Intent displayScreen = new Intent(LoginActivity.this, DisplayScreen.class);
        startActivity(displayScreen);
    }

    @Override
    public void onClick(View view)
    {
        switch(view.getId()){
            case R.id.btnMatch:
                login();
                break;
            case R.id.btnExit:
                startActivity(new Intent(this, MainActivity.class));
                break;
        }
    }

}